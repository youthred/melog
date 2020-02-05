package net.add1s.security;

import net.add1s.entity.sys.Permission;
import net.add1s.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author mahoshojo
 */
@Component("/myFilterInvocationSecurityMetadataSource")
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private final PermissionService permissionService;

    private Map<String, Collection<ConfigAttribute>> map = null;

    public MyFilterInvocationSecurityMetadataSource(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /**
     * 加载所有权限资源
     */
    public void loadAllResourceDefine() {
        map = new HashMap<>(1);
        List<Permission> permissions = permissionService.findAll();
        for (Permission permission : permissions) {
            ConfigAttribute configAttribute = new SecurityConfig(permission.getName());
            List<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>() {{
                add(configAttribute);
            }};
            map.put(permission.getUrl(), configAttributes);
        }
    }

    /**
     * 判断当前登录用户请求的url是否在权限列表中
     * 若在，decide()
     * 若不在，抛出异常AccessDeniedException，禁止访问
     * 若是返回null则表示不做任何操作，直接放行
     *
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (map == null) {
            loadAllResourceDefine();
        }
        HttpServletRequest request = ((FilterInvocation) o).getRequest();
        for (Map.Entry<String, Collection<ConfigAttribute>> entry : map.entrySet()) {
            String url = entry.getKey();
            if (new AntPathRequestMatcher(url).matches(request)) {
                return map.get(url);
            }
        }

//        throw new AccessDeniedException("");
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
