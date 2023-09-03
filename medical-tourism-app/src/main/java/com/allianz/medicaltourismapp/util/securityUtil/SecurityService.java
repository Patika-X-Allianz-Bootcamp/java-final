package com.allianz.medicaltourismapp.util.securityUtil;

import com.allianz.medicaltourismapp.database.entity.roles.AdminEntity;
import com.allianz.medicaltourismapp.database.entity.roles.HospitalSecretaryEntity;
import com.allianz.medicaltourismapp.database.entity.roles.UserEntity;
import com.allianz.medicaltourismapp.database.repository.AdminEntityRepository;
import com.allianz.medicaltourismapp.database.repository.HospitalSecretaryEntityRepository;
import com.allianz.medicaltourismapp.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.Optional;

//@Service
//public class SecurityService implements UserDetailsService {
//
//
//    @Autowired
//    UserEntityRepository userEntityRepository;
//    @Autowired
//    AdminEntityRepository adminEntityRepository;
//    @Autowired
//    HospitalSecretaryEntityRepository hospitalSecretaryRepository;

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<UserEntity> user = userEntityRepository.findByEmail(email);
////        Optional<AdminEntity> admin = adminEntityRepository.findByEmail(email);
////        Optional<HospitalSecretaryEntity> secretary = hospitalSecretaryRepository.findByEmail(email);
//
////        if (user.isEmpty() && admin.isEmpty() && secretary.isEmpty()) {
////            throw new UsernameNotFoundException("Could not findUser with email =" + email);
////        }
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        User u = new User(email,"",authorities);
//        if (user.isPresent()) {
//             u =  new User(email,
//                    user.get().getPassword(),
//                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_user")));
////        } else if (admin.isPresent()) {
////             u =  new User(email,
////                    admin.get().getPassword(),
////                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_admin")));
////
////        } else if (secretary.isPresent()) {
////             u =  new User(email,
////                    secretary.get().getPassword(),
////                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_secretary")));
//
//
//        }
//        return u;
//
//    }
//
//}


@Service
public class SecurityService implements UserDetailsService {


    @Autowired
    HospitalSecretaryEntityRepository secretaryEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<HospitalSecretaryEntity> user = secretaryEntityRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not findUser with username =" + username);
        }

        return new User(username,
                user.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_user")));
    }
}
