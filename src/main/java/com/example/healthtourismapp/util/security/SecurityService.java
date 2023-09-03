package com.example.healthtourismapp.util.security;

import com.example.healthtourismapp.database.entities.PatientEntity;
import com.example.healthtourismapp.database.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class SecurityService implements UserDetailsService {


    @Autowired
    PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PatientEntity> user = patientRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not findUser with username =" + username);
        }

        return new User(username,
                user.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_user")));
    }
}
