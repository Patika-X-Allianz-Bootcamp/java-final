package com.patika.healthtourism.service;

import com.patika.healthtourism.database.entity.RoleEntity;
import com.patika.healthtourism.database.repository.RoleEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    RoleEntityRepository roleEntityRepository;

    public RoleService(RoleEntityRepository roleEntityRepository) {
        this.roleEntityRepository = roleEntityRepository;
    }
    public void createRole(String roleName){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(roleName);
        roleEntityRepository.save(roleEntity);
    }
}
