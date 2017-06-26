/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.manager.console;

import com.geekcattle.model.console.Role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:32
 */
public interface RoleMapper extends JpaRepository<Role,String> {
    
	@Query("from Role r where r.enable=?1 ")
    List<Role> findAllByEnable(Integer enable);
}
