package cn.security.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author jumping-張文平
 * @Date 2019/11/20 14:37
 * @Version 1.0
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    //定义用户信息服务（查询用户信息）
    @Bean
    public UserDetailsService userDetailsService(){
        return null;
    }

    //密码编码器
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //安全拦截机制（最重要）

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("p1") //访问/r/r1时需要认证
                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()    // 所有r/下的资源必须通过认证才可以访问资源
                .anyRequest().permitAll()   //除了 /r 开头的所有请求都不用认证
                .and()
                .formLogin()
                .successForwardUrl("/login-success"); //自定义登录成功的页面地址
    }
}
