package cn.fan.txclient1.banka;


import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author shen
 * @Date 2019/2/26 17:52
 **/
@org.springframework.stereotype.Service
public class AService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    BankBClient bankBClient;

    @LcnTransaction
//    @Transactional
    public String start(int money) {
        String user = "shen";
        String state = bankBClient.addMoney(money,user);
        if ("success".equals(state)){
            Account account =  new Account();
            account.setMoney(money);
            account.setUser(user);
            int res = accountDao.update(account);
            throw new RuntimeException("error runtime");
//            return res>0?"success":"error";
        }
        return "error";
    }
}
