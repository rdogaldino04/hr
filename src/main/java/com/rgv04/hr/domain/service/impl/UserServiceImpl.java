package com.rgv04.hr.domain.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.assembler.UserModelAssembler;
import com.rgv04.hr.domain.dto.RoleDTO;
import com.rgv04.hr.domain.dto.UserFilter;
import com.rgv04.hr.domain.dto.UserModel;
import com.rgv04.hr.domain.exception.BusinessException;
import com.rgv04.hr.domain.exception.EntityNotFoundException;
import com.rgv04.hr.domain.model.Role;
import com.rgv04.hr.domain.model.User;
import com.rgv04.hr.domain.repository.RoleRepository;
import com.rgv04.hr.domain.repository.UserRepository;
import com.rgv04.hr.domain.service.UserService;
import com.rgv04.hr.domain.specs.UserSpecs;
import com.rgv04.hr.infrastructure.core.data.PageWrapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;     
    private final PasswordEncoder passwordEncoder;
    private final UserModelAssembler userModelAssembler;
    private final PagedResourcesAssembler<User> pagedResourcesAssembler;

    @Lazy
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, @Lazy PasswordEncoder passwordEncoder,
    UserModelAssembler userModelAssembler, PagedResourcesAssembler<User> pagedResourcesAssembler) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userModelAssembler = userModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @Override
    public User save(User user) {
        log.info("Saving user {}", user.getName());
        if (user.isNew())
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        userRepository.detach(user);
        Optional<User> userExisting = userRepository.findByUsername(user.getUsername());
        boolean exist = userExisting.isPresent() && !userExisting.get().equals(user);
        if (exist) {
            throw new BusinessException(
                String.format("There is already a registered user with the username %s", user.getUsername())
            );
        }
        return userRepository.save(user);        
    }

    @Override
    public RoleDTO saveRole(RoleDTO roleDTO) {
        return roleDTO.toDTO(roleRepository.save(roleDTO.toEntity()));
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public CollectionModel<UserModel> getUsers(UserFilter filter) {
        return userModelAssembler.toCollectionModel(userRepository.getAll(filter));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
        log.info("User found in the database: {}", username);
        User user = userOptional.get();
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format("There is no user account with code %d", id)));
    }

    @Override
    public CollectionModel<UserModel> findAllPaginatedUsers(UserFilter userFilter, Pageable pageable) {
    	Page<User> userPage = userRepository.findAll(UserSpecs.usingFilter(userFilter), pageable);        
        userPage = new PageWrapper<>(userPage, pageable);
        return pagedResourcesAssembler.toModel(userPage, userModelAssembler);
    }

}
