package com.healthtourism.healthtourism.util.security;

import com.healthtourism.healthtourism.database.entities.RoleEntity;
import com.healthtourism.healthtourism.database.entities.UserEntity;
import com.healthtourism.healthtourism.database.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SecurityService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not findUser with email =" + email);
        }

        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
        for (RoleEntity role : userRepository.findUserWithRolesByEmail(email).getRoles()) {
            simpleGrantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" +  role.getName()));
        }

        return new User(
                email,
                user.get().getPassword(),
                simpleGrantedAuthorityList);
    }


}
