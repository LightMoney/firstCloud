package cn.fan.service.impl;

import cn.fan.dao.DeptMapper;
import cn.fan.entity.Dept;
import cn.fan.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Auth Mr.luo
 * Date 2019/12/25 14:51
 **/
@Service
public class DeptServiceImpl implements DeptService {

   @Autowired
    private DeptMapper  deptMapper;

    @Override
    public boolean add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }
}
