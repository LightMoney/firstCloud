package cn.fan.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//授权码模式
    // 1. 可以get访问
    // http://localhost:8011/oauth/authorize?client_id=root&response_type=code&redirect_uri=http://localhost:8011/
//获取code

    // 2. 必须post访问
    // http://localhost:8011/oauth/token?grant_type=authorization_code&code=授权码&redirect_uri=http://localhost:8011/&client_id=clientId&client_secret=secret

//    密码模式
//    http://localhost:8011/oauth/token?grant_type=password&client_id=root&client_secret=user&username=admin&password=123456
//隐藏模式  用于只有前端
//    http://localhost:8028/oauth/authorize?client_id=clientId&response_type=token&redirect_uri=http://localhost:8028/&scope=all
//凭证模式  用于没有前端
//    http://localhost:8028/oauth/token?grant_type=client_credentials&client_id=clientId&client_secret=secret

    //刷新token
//    http://localhost:8011/oauth/token?grant_type=refresh_token&client_id=root&client_secret=user&refresh_token=

    @GetMapping("/user/save")
    public String save() {
        return "save";
    }


    @GetMapping("/save/no")
    public String noSave() {
        return "no save";
    }
}

