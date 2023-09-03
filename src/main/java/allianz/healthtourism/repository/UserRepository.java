package allianz.healthtourism.repository;

import allianz.healthtourism.base.BaseRepository;
import allianz.healthtourism.entity.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByEmail(String email);
}
