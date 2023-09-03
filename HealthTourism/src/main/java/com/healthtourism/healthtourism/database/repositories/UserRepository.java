package com.healthtourism.healthtourism.database.repositories;

import com.healthtourism.healthtourism.database.entities.UserEntity;
import com.healthtourism.healthtourism.util.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends IBaseRepository<UserEntity> {
    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT u FROM UserEntity u JOIN FETCH u.roles WHERE u.email = :email")
    UserEntity findUserWithRolesByEmail(@Param("email") String email);
}
