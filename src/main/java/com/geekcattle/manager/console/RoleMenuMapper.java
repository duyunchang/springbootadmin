/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.manager.console;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.geekcattle.model.console.RoleMenu;

public interface RoleMenuMapper extends JpaRepository<RoleMenu,String> {
	
	 @Query("from RoleMenu r where r.roleId=?1 ")
	 List<RoleMenu> findByRoleId(String roleId);
	 
	 @Modifying 
	 int deleteByRoleId(String roleId);
	 
	 @Modifying 
	 int deleteByMenuId(String menuId);
}