package cn.fan.oauth2.config;


import cn.fan.oauth2.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * 授权服务配置
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Bean
    public JdbcTokenStore jdbcTokenStore(){
        return new JdbcTokenStore(dataSource);
    }

//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;
//
//    @Bean
//    public RedisTokenStore redisTokenStore(){
//        return new RedisTokenStore(redisConnectionFactory);
//    }

    @Autowired
    private UserLoginService userLoginService;

    /**
     * 配置一个客户端
     * <p>
     * 既可以通过授权码方式获取令牌，也可以通过密码方式获取令牌
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("clientId")
////                .secret("secret")
////                加密
//                .secret(new BCryptPasswordEncoder().encode("secret"))//客户端秘钥
//                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
//                .scopes("all")
//                .autoApprove(true)//自动批准（如需用户点击可不设置，默认false）
//                .redirectUris("http://localhost:8011/");
        clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
    }

    /**
     * 配置token管理
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        //endpoints.tokenStore(inMemoryTokenStore())
        //endpoints.tokenStore(redisTokenStore())
//        采用数据库存储token   oauth_refresh_token   oauth_access_token
        endpoints.tokenStore(jdbcTokenStore())
                //配置令牌生成
                .accessTokenConverter(accessTokenConverter())
                //通过注入密码授权被打开AuthenticationManager
                .authenticationManager(authenticationManager)
                //该字段设置设置refresh token是否重复使用,true:reuse;false:no reuse.
                .reuseRefreshTokens(false)
                //刷新令牌授权将包含对用户详细信息的检查，以确保该帐户仍然活动,因此需要配置userDetailsService(不刷新也可不配)
                .userDetailsService(userLoginService);

    }

    /**
     * 配置jwt转换器
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        使用的是对称加密，可采用非对称
        converter.setSigningKey("secret");
        return converter;
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()") //允许所有人请求令牌
                .checkTokenAccess("isAuthenticated()") //已验证的客户端才能请求check_token端点
                .allowFormAuthenticationForClients();
    }


}
