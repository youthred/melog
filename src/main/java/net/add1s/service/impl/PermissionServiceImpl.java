package net.add1s.service.impl;

import net.add1s.entity.sys.Permission;
import net.add1s.entity.sys.RolePermission;
import net.add1s.mapper.PermissionMapper;
import net.add1s.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author mahoshojo
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionMapper permissionMapper;

    public PermissionServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }


    @Override
    public List<RolePermission> findAllRolePermissions() {
        return permissionMapper.findAllRolePermissions();
    }

    @Override
    public Set<String> findUrlsByEmail(String email) {
        return permissionMapper.findUrlsByEmail(email);
    }

    @Override
    public List<Permission> findAll() {
        return permissionMapper.findAll();
    }

    @Override
    public List<Permission> findByEmail(String email) {
        return permissionMapper.findByEmail(email);
    }
}
