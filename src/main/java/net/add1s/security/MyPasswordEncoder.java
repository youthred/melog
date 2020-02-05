package net.add1s.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @author mahoshojo
 */
@Component("myPasswordEncoder")
public class MyPasswordEncoder implements PasswordEncoder {

    /**
     * 加密前台传来的密码
     *
     * @param charSequence
     * @return
     */
    @Override
    public String encode(CharSequence charSequence) {
        return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
    }

    /**
     * 密码匹配
     *
     * @param charSequence 前台传来的密码
     * @param s 数据库里已经加密的密码
     * @return
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
    }
}
