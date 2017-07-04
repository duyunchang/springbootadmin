/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.service.console;

import com.geekcattle.Constants.Constants;
import com.geekcattle.manager.BaseNativeSqlRepository;
import com.geekcattle.manager.console.RoleMapper;
import com.geekcattle.model.BaseEntity;
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
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private BaseNativeSqlRepository  BaseNativeSqlManager;
    
    @Autowired 
    private BaseEntity baseEntity;

    public List<Role> getPageList(Role role) {
    	Sort sort = new Sort(Sort.Direction.DESC, "createdAt");  
    	Pageable pageable = new PageRequest(baseEntity.getOffset(), baseEntity.getLimit(), sort); 
        //PageHelper.offsetPage(role.getOffset(), role.getLimit(), CamelCaseUtil.toUnderlineName(role.getSort())+" "+role.getOrder());
    	List<Role> content =roleMapper.findAllpage(pageable);
    	
    	//List<Role> content = roleMapper.findAll(pageable).getContent();
    	return content;
        
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
    @Transactional
    public void deleteById(String id) {
        roleMapper.delete(id);
    }

    @Transactional
    public int save(Role role) {
    	int flag=Constants.update_fail;
    	
    	if(Constants.update_fail==roleMapper.findCountByRoleName(role.getRoleName())){    		
    		 roleMapper.save(role);  		 
    		 flag=Constants.update_success;
    	}
       return flag;
    }

    @Transactional
    public int insert(Role role){
        Role save = roleMapper.save(role);
        if(save==null){
        	return Constants.update_fail;
        }
        return Constants.update_success;
    }

    public Set<String> findRoleByUserId(String userId) {
    	List<String> findRoleByUserId = BaseNativeSqlManager.findRoleByUserId(userId);
    	Set<String>  set=new HashSet<String>();
    	set.addAll(findRoleByUserId);
    	
        return set;
    }

    public List<Role> selectRoleListByAdminId(String Id){
        return BaseNativeSqlManager.selectRoleListByAdminId(Id);
        
       // return  roleMapper.selectRoleListByAdminId(Id);
    }

}
