package cn.fan.service;

import cn.fan.entity.Dept;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Auth Mr.fgy
 * Date 2019/12/25 14:46
 **/
public interface DeptService {
    public boolean add(Dept dept);
    public Dept get(Long id);
//    public List<Dept> list();
    public PageInfo<Dept> list(int page,int size);
}
