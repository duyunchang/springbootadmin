/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.mapper.console;

import com.geekcattle.model.console.Admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:32
 */
public interface AdminMapper  extends JpaRepository<Admin ,String> {
    Admin selectByUsername(String username);
    
    int updatePasswordByUid(String password,String uid);
    
    //void deleteById(String Id);
    
  //实现分页功能  
  // Page<Admin> findAll(Pageable pageable); 
}
