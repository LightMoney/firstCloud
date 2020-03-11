package cn.fan.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Auth fgy
 * Date 2019/12/25 13:39
 **/
@Data
@NoArgsConstructor
public class Dept implements Serializable {//--- db_dept
    private  long  deptno;//主键
    private  String dname;//部门名称
    private  String db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname) {
        this.dname = dname;
    }
}
