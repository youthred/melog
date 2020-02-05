package net.add1s.mapper;

import net.add1s.entity.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author mahoshojo
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 通过邮箱查找对应用户
     *
     * @param email
     * @return
     */
    User findUserByUsername(@Param("email") String email);
}
