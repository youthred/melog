package net.add1s.mapper;

import net.add1s.entity.sys.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mahoshojo
 */
@Mapper
@Repository
public interface RoleMapper {

    /**
     * 通过用户ID查找其所有角色
     *
     * @param userId
     * @return
     */
    List<Role> findRolesByUserId(@Param("userId") Long userId);
}
