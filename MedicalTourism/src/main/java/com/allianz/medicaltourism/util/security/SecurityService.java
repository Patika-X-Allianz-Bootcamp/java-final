package com.allianz.medicaltourism.util.security;

import com.allianz.medicaltourism.database.entity.RoleEntity;
import com.allianz.medicaltourism.database.entity.UserEntity;
import com.allianz.medicaltourism.database.repository.RoleEntityRepository;
import com.allianz.medicaltourism.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SecurityService implements UserDetailsService {


    @Autowired
    UserEntityRepository userEntityRepository;
    @Autowired
    RoleEntityRepository roleEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userEntityRepository.findByEmail(email);
        List<RoleEntity> roles = roleEntityRepository.findAll();
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not findUser with email =" + email);
        }
        for (RoleEntity role : roles) {
            for(RoleEntity role1 : user.get().getRoles()){
                if(role1.equals(role)){
                    return new User(email,
                            user.get().getPassword(),
                            Collections.singletonList(new SimpleGrantedAuthority(role.getName())));
                }
            }
        }
        return new User(email,
                user.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_anonymus")));
    }
}
