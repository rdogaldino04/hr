package com.rgv04.hr.api.controller;

import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rgv04.hr.domain.assembler.UserModelAssembler;
import com.rgv04.hr.domain.dto.RoleDTO;
import com.rgv04.hr.domain.dto.UserFilter;
import com.rgv04.hr.domain.dto.UserInput;
import com.rgv04.hr.domain.dto.UserModel;
import com.rgv04.hr.domain.dto.UserWithPasswordInput;
import com.rgv04.hr.domain.model.Role;
import com.rgv04.hr.domain.model.User;
import com.rgv04.hr.domain.service.UserService;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
	
	private String secret = "secret";

    private final UserService userService;

    private final UserModelAssembler userModelAssembler;

    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Object> getUsers(UserFilter userFilter, boolean isPagination, @PageableDefault(size = 6) Pageable pageable) {
        if (isPagination) {
        	return ResponseEntity.ok(this.userService.findAllPaginatedUsers(userFilter, pageable));
        }
        return ResponseEntity.ok(userService.getUsers(userFilter));
    }

    @PostMapping
    public ResponseEntity<UserModel> save(@RequestBody @Valid UserWithPasswordInput userInput) {
        User user = new User();
        modelMapper.map(userInput, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userModelAssembler.toModel(userService.save(user)));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserModel> update(@PathVariable Long id, @RequestBody @Valid UserInput userInput) {
        User currentUser = userService.getUserById(id);
        modelMapper.map(userInput, currentUser);
        return ResponseEntity
                .ok()
                .body(userModelAssembler.toModel(userService.save(currentUser)));
    }

    @PostMapping("roles")
    public ResponseEntity<RoleDTO> saveRole(@RequestBody RoleDTO roleDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/roles").toString());
        return ResponseEntity.created(uri).body(userService.saveRole(roleDTO));
    }

    @PostMapping("roles/add-to-user")
    public ResponseEntity<Object> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("token/refresh")
    public ResponseEntity<Void> refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);
                String acessToken = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",
                                user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("acess_token", acessToken);
                tokens.put("refresh_token", refreshToken);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
                return ResponseEntity.noContent().build();
            } catch (Exception e) {
                response.setHeader("error", e.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
                return ResponseEntity.noContent().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("current")
    public ResponseEntity<UserCurrentModel> getUserCurrent(Authentication authentication) {
        List<String> roleNames = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(UserCurrentModel.builder()
                .username(authentication.getName())
                .roleNames(roleNames)
                .build());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserModel> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userModelAssembler.toModel(this.userService.getUserById(id)));
    }

}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}

@Builder
@Getter
class UserCurrentModel {
    private String username;
    private List<String> roleNames;
}
