package com.allianz.meliorator.database.repository;

import com.allianz.meliorator.database.entity.Users;
import com.allianz.meliorator.util_db.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends IBaseRepository<Users> {
    Optional<Users> findByUsername(String username);
}
