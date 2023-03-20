package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.RoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    RoleEntity findById(long id);
    RoleEntity findByRoleName(String roleName);
    List<RoleEntity> findAllByRoleNameIsLike(String roleName);
}
