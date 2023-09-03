package com.allianz.meliorator.util_security;

import com.allianz.meliorator.database.entity.Users;
import com.allianz.meliorator.database.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class SecurityService implements UserDetailsService {


    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = usersRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not findUser with username =" + username);
        }

        return new Users(username,
                user.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_users")));
    }
}
