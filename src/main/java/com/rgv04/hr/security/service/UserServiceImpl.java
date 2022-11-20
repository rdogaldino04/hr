package com.rgv04.hr.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rgv04.hr.exception.BusinessException;
import com.rgv04.hr.security.model.Role;
import com.rgv04.hr.security.model.User;
import com.rgv04.hr.security.repository.RoleRepository;
import com.rgv04.hr.security.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;     
    private final PasswordEncoder passwordEncoder;

    @Lazy
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
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
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username).get();
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).get();
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository
            .findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
    }

}
