/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.mapper.console;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geekcattle.model.console.AdminRole;

public interface AdminRoleMapper  extends JpaRepository<AdminRole,String> {
	
	List<AdminRole> findByRoleId(String roleId);
}