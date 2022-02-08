package com.App.Vet.dataAccess.abstracts;

import com.App.Vet.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}
