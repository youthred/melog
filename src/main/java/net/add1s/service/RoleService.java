package net.add1s.service;

import net.add1s.entity.sys.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mahoshojo
 */
public interface RoleService {

    /**
     * 通过用户ID查找其所有角色
     *
     * @param userId
     * @return
     */
    List<Role> findRolesByUserId(@Param("userId") Long userId);
}
