package com.App.Vet.business.concretes;

import com.App.Vet.business.abstracts.RoleService;
import com.App.Vet.dataAccess.abstracts.RoleDao;
import com.App.Vet.entities.concretes.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleManager implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleManager(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAll() {
        return this.roleDao.findAll();
    }
}
