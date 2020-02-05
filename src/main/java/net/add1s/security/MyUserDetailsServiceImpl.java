package net.add1s.security;

import net.add1s.entity.sys.Permission;
import net.add1s.entity.sys.User;
import net.add1s.service.PermissionService;
import net.add1s.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mahoshojo
 */
@Component("myUserDetailsServiceImpl")
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private final PermissionService permissionService;

    private final UserService userService;

    public MyUserDetailsServiceImpl(PermissionService permissionService, UserService userService) {
        this.permissionService = permissionService;
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.findUserByUsername(s);
        if (user != null) {
            List<Permission> permissions = permissionService.findByEmail(s);
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("邮箱 " + s + " 不存在");
        }
    }
}
