/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.manager.console;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.geekcattle.model.console.AdminRole;

public interface AdminRoleMapper  extends JpaRepository<AdminRole,String> {
	
	@Query("from AdminRole l where l.roleId=?1")
	List<AdminRole> findByRoleId(String roleId);
}