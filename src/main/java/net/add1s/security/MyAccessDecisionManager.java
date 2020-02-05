package net.add1s.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author mahoshojo
 */
@Component("myAccessDecisionManager")
public class MyAccessDecisionManager implements AccessDecisionManager {

    /**
     * 判断是否拥有权限
     *
     * @param authentication
     * @param o
     * @param collection
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if (collection == null || collection.size() == 0) {
            return;
        }
//        Iterator<ConfigAttribute> iterator = collection.iterator();
//        while (iterator.hasNext()) {
//            String needRole = iterator.next().getAttribute();
//            for (GrantedAuthority authority : authentication.getAuthorities()) {
//                if (needRole.trim().equals(authority.getAuthority())) {
//                    return;
//                }
//            }
//        }
        for (ConfigAttribute attribute : collection) {
            String needRole = attribute.getAttribute();
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                // 判断是否存在该资源权限，true则放行
                if (needRole.trim().equals(authority.getAuthority())) {
                    return;
                }
            }
        }

        // 未登录或无相应的权限则必须抛出此异常
        throw new AccessDeniedException("");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
