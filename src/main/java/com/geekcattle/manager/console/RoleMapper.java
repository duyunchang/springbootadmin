/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.manager.console;

import com.geekcattle.model.console.Role;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:32
 */
public interface RoleMapper extends JpaRepository<Role,String> {
    
	@Query("from Role r where r.enable=?1 ")
    List<Role> findAllByEnable(Integer enable);
	@Query("from Role r where 1=1 ")
	List<Role> findAllpage(Pageable pageable);
	@Query("select count (*) from Role r where roleName=?1 ")
	int findCountByRoleName(String roleName);
	
	
//	@Query("from Role r inner join AdminRole ar on r.roleId = ar.roleId left join Admin a on a.uid = ar.adminId  where a.uid = ?1 and r.enable = 1")
//	List<Role> selectRoleListByAdminId(String Id);
}
