package cn.fan.oauth2resource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * 资源服务器
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        /*为RestTemplate配置异常处理器0*/
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        return restTemplate;
    }

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(new JwtTokenStore(accessTokenConverter())).stateless(true);

        /* 配置令牌验证 */
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
        remoteTokenServices.setRestTemplate(restTemplate);
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8011/oauth/check_token");//检查令牌是否有效
        remoteTokenServices.setClientId("root");
        remoteTokenServices.setClientSecret("user");

        resources.tokenServices(remoteTokenServices).stateless(true);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        使用的是对称加密，可采用非对称
        converter.setSigningKey("secret");
        return converter;
    }

    /* 配置资源拦截规则 */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
//--todo 将资源服务器和认证放一起时总有一方要被拦截，分开就无问题
        // /save/no不受保护
        // /user/save 受保护
        http.authorizeRequests()
                .antMatchers("/save/**")
                .permitAll()
                .anyRequest()
                .authenticated();


        http.exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
