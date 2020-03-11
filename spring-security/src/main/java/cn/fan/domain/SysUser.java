package cn.fan.domain;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

/**
 * Auth Mr.luo
 * Date 2019/12/31 9:06
 **/
@Data
public class SysUser {
    private  Integer id;
    private  String name;
    private  String password;

}
