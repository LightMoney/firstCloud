package cn.fan.oauth2.mapper;


import cn.fan.oauth2.model.SysUser;

public interface SysUserMapper {

    SysUser selectByUserName(String username);
}


