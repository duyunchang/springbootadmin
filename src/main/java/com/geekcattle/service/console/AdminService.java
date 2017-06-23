/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.service.console;

import com.geekcattle.mapper.console.AdminMapper;
import com.geekcattle.model.console.Admin;
import com.geekcattle.util.CamelCaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:43
 */
@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public List<Admin> getPageList(Admin admin) {
    	Sort sort = new Sort(Sort.Direction.DESC, "created_at");  
    	Pageable pageable = new PageRequest(admin.getOffset(), admin.getLimit(), sort); 
    	
        //PageHelper.offsetPage(admin.getOffset(), admin.getLimit(), CamelCaseUtil.toUnderlineName(admin.getSort())+" "+admin.getOrder());
        return adminMapper.findAll(pageable).getContent();
    }

    public Integer getCount(String username){
    	Admin selectByUsername = adminMapper.selectByUsername(username);
    	if(selectByUsername!=null&&selectByUsername.getUid()!=null){
    		return 1;
    	}else{
    		return 0;
    	}
    	
        //return adminMapper.selectCountByExample(example);
    }

    public Admin getById(String id) {
        return adminMapper.findOne(id);
    }

    public Admin findByUsername(String username) {
        return adminMapper.selectByUsername(username);
    }

    public void deleteById(String id) {
        adminMapper.delete(id);
    }

    public void insert(Admin admin){
        adminMapper.save(admin);
    }

    public void save(Admin admin) {
    	adminMapper.save(admin);
    	
//        if (admin.getUid() != null) {
//            adminMapper.updateByPrimaryKey(admin);
//        } else {
//            adminMapper.insert(admin);
//        }
    }

    public void updateExample(String newPassword,String uid){
    	
        adminMapper.updatePasswordByUid(newPassword, uid);
    }



}