/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.manager.console;

import com.geekcattle.model.console.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:32
 */
public interface AdminMapper  extends JpaRepository<Admin ,String> {
    
	@Query("from Admin l where l.username=?1")
	Admin selectByUserName(String username);
    
    @Modifying 
    @Query("update  Admin l  set l.password =?1  where l.uid=?2")
    int updatePasswordByUid(String password,String uid);
    
  //实现分页功能  
  // Page<Admin> findAll(Pageable pageable); 
}
