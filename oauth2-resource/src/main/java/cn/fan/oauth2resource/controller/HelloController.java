package cn.fan.oauth2resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 1. 可以get访问
    // http://localhost:8011/oauth/authorize?client_id=clientId&response_type=code&redirect_uri=http://localhost:8011/
//获取code

    // 2. 必须post访问
    // http://localhost:8011/oauth/token?grant_type=authorization_code&code=授权码&redirect_uri=http://localhost:8011/&client_id=clientId&client_secret=secret

    /** 受保护的资源 */
    @GetMapping("/user/save")
    public String save(){
        return "save";
    }

    /** 不受保护的资源 */
    @GetMapping("/save/no")
    public String noSave(){
        return "no save";
    }
}

