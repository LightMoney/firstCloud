package cn.fan.txclient1.banka;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountDao {

    @Update("update bank_a set money = money-#{money} where user=#{user}")
    int update(Account account);
}
