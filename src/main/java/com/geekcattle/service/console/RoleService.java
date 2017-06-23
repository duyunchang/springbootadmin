/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.service.console;

import com.geekcattle.mapper.console.RoleMapper;
import com.geekcattle.model.console.Admin;
import com.geekcattle.model.console.Role;
import com.geekcattle.util.CamelCaseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:47
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getPageList(Role role) {
    	Sort sort = new Sort(Sort.Direction.DESC, "created_at");  
    	Pageable pageable = new PageRequest(role.getOffset(), role.getLimit(), sort); 
        //PageHelper.offsetPage(role.getOffset(), role.getLimit(), CamelCaseUtil.toUnderlineName(role.getSort())+" "+role.getOrder());
        return roleMapper.findAll(pageable).getContent();
    }

    public List<Role> getFromAll(){
//        Example example = new Example;
//        example.createCriteria()
//                .andCondition("enable = ", 1);
//
//        return roleMapper.selectByExample(example);
        
        return roleMapper.findAllByEnable(1);
    }

//    public Integer getCount(Example example){
//        return roleMapper.selectCountByExample(example);
//    }

    public Role getById(String id) {
    	
    	
        return roleMapper.findOne(id);
    }

//    public List<Role> getById(Role roles) {
//       
//    	return roleMapper.findAll( roles.getRoleId());
//    }

    public void deleteById(String id) {
        roleMapper.delete(id);
    }

    public void save(Role role) {
        roleMapper.save(role);
    }

    public void insert(Role role){
        roleMapper.save(role);
    }

    public Set<String> findRoleByUserId(String userId) {
    	List<Role> findRoleByUserId = roleMapper.findRoleByUserId(userId);
    	Set<String>  set=new HashSet<String>();
    	for(Role role:findRoleByUserId){
    		set.add(role.getRoleName());
    		
    	}
        return set;
    }

    public List<Role> selectRoleListByAdminId(String Id){
        return roleMapper.selectRoleListByAdminId(Id);
    }

}
