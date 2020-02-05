package net.add1s.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.add1s.entity.common.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/**
 * @author mahoshojo
 */
@Component("/mySecurityConfig")
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MyUserDetailsServiceImpl myUserDetailsService;

    @Autowired
    private MyFilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @Autowired
    private MyAccessDecisionManager accessDecisionManager;

    @Autowired
    private MyAuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(myPasswordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // ignoring() 忽略验证，直接放行
//        web.ignoring().antMatchers("/", "/register", "/js/**", "/css/**", "/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(accessDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin().loginPage("/signIn").loginProcessingUrl("/doLogin")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll()
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.setContentType("application/json;charset=UTF-8");
                    PrintWriter writer = httpServletResponse.getWriter();
                    writer.write(objectMapper.writeValueAsString(AjaxResult.me().setSuccess(true)));
                    writer.flush();
                    writer.close();
                })
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.setContentType("application/json;charset=UTF-8");
                    PrintWriter writer = httpServletResponse.getWriter();
                    writer.write(objectMapper.writeValueAsString(AjaxResult.me().setSuccess(false).setMsg("用户名或密码错误")));
                    writer.flush();
                    writer.close();
                })
                .and().logout().permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
    }
}
