/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.mapper.console;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geekcattle.model.console.RoleMenu;

public interface RoleMenuMapper extends JpaRepository<RoleMenu,String> {
	
	 List<RoleMenu> findByRoleId(String roleId);
	 
	 int deleteByRoleId(String roleId);
	 
	 int deleteByMenuId(String menuId);
}