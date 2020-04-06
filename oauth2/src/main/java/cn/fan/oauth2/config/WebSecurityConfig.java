package cn.fan.oauth2.config;

import cn.fan.oauth2.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* 跨域伪造请求限制=无效 */
        http.csrf().disable();
        /* 开启授权认证 */
        http.authorizeRequests()
            .antMatchers("/oauth/**").permitAll() //允许访问授权接口
            .anyRequest().authenticated();
        /* 登录配置 */
        http.formLogin().permitAll();
        /* session 设置为 IF_REQUIRED 有需要才生成 */
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }

    @Autowired
    private UserLoginService userLoginService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");

//        加密
//        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
//                .withUser("admin").
//                password(new BCryptPasswordEncoder().encode("admin")).roles("USER");

//        动态从数据库查询验证
        auth.userDetailsService(userLoginService).passwordEncoder(passwordEncoder());
//        admin    123456
    }

    /** 授权服务配置需要用到这个 bean  */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    /** 配置密码加密为 不加密 */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

    /** 配置密码加密*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
