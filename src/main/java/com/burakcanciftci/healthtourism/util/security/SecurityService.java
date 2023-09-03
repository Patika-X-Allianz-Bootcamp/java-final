package com.burakcanciftci.healthtourism.util.security;

import com.burakcanciftci.healthtourism.database.entity.RoleEntity;
import com.burakcanciftci.healthtourism.database.entity.UserEntity;
import com.burakcanciftci.healthtourism.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class SecurityService implements UserDetailsService {
    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userEntityRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not findUser with email =" + email);
        }

        Collection<SimpleGrantedAuthority> simpleGrantedAuthorityCollection = new ArrayList<>();

        for(RoleEntity roleEntity : user.get().getRoles()){
            simpleGrantedAuthorityCollection.add(new SimpleGrantedAuthority("ROLE_" + roleEntity.getName()));
        }

        return new User(email,
                user.get().getPassword(),
                simpleGrantedAuthorityCollection);
    }
}
