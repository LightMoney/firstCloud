package cn.fan.dao;

import cn.fan.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Auth Mr.luo
 * Date 2019/12/25 14:37
 **/
@Mapper
public interface DeptMapper {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
