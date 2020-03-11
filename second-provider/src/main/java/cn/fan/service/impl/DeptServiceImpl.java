package cn.fan.service.impl;

import cn.fan.dao.DeptMapper;
import cn.fan.service.DeptService;
import cn.fan.entity.Dept;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

//    @Override
//    public List<Dept> list() {
//        return deptMapper.findAll();
//    }

    @Override
    public PageInfo<Dept> list(int page,int size) {
        PageHelper.startPage(page,size);
        List<Dept> list = deptMapper.findAll();
        PageInfo<Dept> info=new PageInfo<Dept>(list);
        return info;
    }
}
