/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.service.console;

import com.geekcattle.manager.console.AdminRoleMapper;
import com.geekcattle.model.console.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author geekcattle
 * date 2016/12/6 0006 上午 10:45
 */
@Service
public class AdminRoleService {

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Transactional
    public void insert(AdminRole adminRole){
        adminRoleMapper.save(adminRole);
    }

    @Transactional
    public void deleteAdminId(String id){
        //Example example = new Example(AdminRole.class);
        //example.createCriteria().andCondition("admin_id =", id);
        //adminRoleMapper.deleteByExample(example);
    	adminRoleMapper.delete(id);
    }

    @Transactional
    public void deleteRoleId(String id){
        //Example example = new Example(AdminRole.class);
       // example.createCriteria().andCondition("role_id =", id);
       // adminRoleMapper.deleteByExample(example);
    	adminRoleMapper.delete(id);
    }

    public AdminRole selectOne(AdminRole adminRole){
        return adminRoleMapper.findOne(adminRole.getAdminId());
    }

    public List<AdminRole> getRoleList(AdminRole adminRole){
    	
    	 //return adminRoleMapper.findAll(adminRole);
    	
    	return adminRoleMapper.findByRoleId(adminRole.getRoleId());
    	
       
    }


}
