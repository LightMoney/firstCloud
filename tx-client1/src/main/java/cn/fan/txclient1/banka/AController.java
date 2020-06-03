package cn.fan.txclient1.banka;

import com.codingapi.txlcn.common.exception.LcnBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author shen
 * @Date 2019/2/26 17:51
 **/
@RestController
public class AController {

    @Autowired
    AService service;

    @GetMapping("/start")
    public String start(@RequestParam("money") int money)  {
        return service.start(money);
    }
}
