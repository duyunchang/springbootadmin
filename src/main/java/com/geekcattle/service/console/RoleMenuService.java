/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.service.console;

import com.geekcattle.manager.console.RoleMenuMapper;
import com.geekcattle.model.console.AdminRole;
import com.geekcattle.model.console.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author geekcattle
 * date 2016/12/6 0006 上午 10:45
 */
@Service
public class RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Transactional
    public void insert(RoleMenu roleMenu){
        roleMenuMapper.save(roleMenu);
    }

    @Transactional
    public void deleteMenuId(String id){
//        Example example = new Example(RoleMenu.class);
//        example.createCriteria().andCondition("menu_id =", id);
//        roleMenuMapper.deleteByExample(example);
        roleMenuMapper. deleteByMenuId(id);
        
    }

    @Transactional
    public void deleteRoleId(String id){
//        Example example = new Example(RoleMenu.class);
//        example.createCriteria().andCondition("role_id =", id);
//        roleMenuMapper.deleteByExample(example);
        
        roleMenuMapper.deleteByRoleId(id);
    }

//    public RoleMenu selectOne(RoleMenu roleMenu){
//        
//    	
//    	return roleMenuMapper.findByRoleId(roleMenu.getRoleId());
//    }

    public List<RoleMenu> getRoleList(RoleMenu roleMenu){
    	
        return roleMenuMapper.findByRoleId(roleMenu.getRoleId());
    }

    

}
