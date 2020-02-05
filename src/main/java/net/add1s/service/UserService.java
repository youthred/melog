package net.add1s.service;

import net.add1s.entity.sys.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author mahoshojo
 */
public interface UserService {

    /**
     * 通过邮箱查找对应用户
     *
     * @param email
     * @return
     */
    User findUserByUsername(@Param("email") String email);
}
