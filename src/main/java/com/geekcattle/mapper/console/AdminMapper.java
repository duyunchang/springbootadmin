/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.mapper.console;

import com.geekcattle.model.console.Admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Modifying 
    @Query("delete from AdminRole ar where ar.adminId = ?1;delete from Admin a where a.uid = ?1;")
    void deleteById(String Id);
    
  //实现分页功能  
  // Page<Admin> findAll(Pageable pageable); 
}
