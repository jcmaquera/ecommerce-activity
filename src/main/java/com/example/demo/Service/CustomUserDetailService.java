package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.Role;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepository.findByEmail(email);
        if(users != null){
            return new User(users.getEmail(), users.getPassword(), mapRolesToAuthorities(users.getRoles()));

        }else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

    }
    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> types) {
        Collection < ? extends GrantedAuthority> mapRoles = types.stream()
                .map(type -> new SimpleGrantedAuthority(type.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}
