package net.add1s.mapper;

import net.add1s.entity.sys.Permission;
import net.add1s.entity.sys.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author mahoshojo
 */
@Mapper
@Repository
public interface PermissionMapper {

    /**
     * 角色权限中间表信息
     *
     * @return
     */
    List<RolePermission> findAllRolePermissions();

    /**
     * 通过email获取对应资源权限
     *
     * @param email
     * @return
     */
    Set<String> findUrlsByEmail(@Param("email") String email);

    /**
     * 查找权限表全部信息
     *
     * @return
     */
    List<Permission> findAll();

    /**
     * 通过email查找对应权限信息
     *
     * @param email
     * @return
     */
    List<Permission> findByEmail(@Param("email") String email);
}
