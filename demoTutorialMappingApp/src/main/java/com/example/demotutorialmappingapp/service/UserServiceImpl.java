package com.example.demotutorialmappingapp.service;

import com.example.demotutorialmappingapp.dto.UserRegistrationDto;
import com.example.demotutorialmappingapp.entity.Role;
import com.example.demotutorialmappingapp.entity.UserEntity;
import com.example.demotutorialmappingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository){
        super();
        this.userRepository  =userRepository;
    }

    @Override
    public UserEntity save(UserRegistrationDto registrationDto){
        UserEntity user = new UserEntity();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);

        if(user == null){
            throw new UsernameNotFoundException("INVALID USER NAME or EMAIL");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolestoAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolestoAuthorities(Collection<Role> roles) {
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }
}
