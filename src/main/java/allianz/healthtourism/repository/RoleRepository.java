package allianz.healthtourism.repository;


import allianz.healthtourism.base.BaseRepository;
import allianz.healthtourism.entity.Role;


public interface RoleRepository extends BaseRepository<Role> {

    Role findByName(String name);

}
