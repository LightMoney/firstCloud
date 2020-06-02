package cn.fan.txclient2.bankb;


import  org.springframework.stereotype.Service;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description TODO
 * @Author shen
 * @Date 2019/2/26 17:52
 **/
@Service
public class BService {

    @Autowired
    AccountDao accountDao;

    @LcnTransaction
    public String addMoney(int money, String user) {
        Account account = new Account();
        account.setMoney(money);
        account.setUser(user);
        int res =  accountDao.update(account);
        return res>0?"success":"error";
    }
}
