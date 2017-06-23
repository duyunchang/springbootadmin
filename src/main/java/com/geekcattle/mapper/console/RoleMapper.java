/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.mapper.console;

import com.geekcattle.model.console.Role;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:32
 */
public interface RoleMapper extends JpaRepository<Role,String> {
    
	//@Query("from Role r where r.roleId in (select a.roleId from adminRole a where a.adminId=?1) order by r.createdAt desc")
	@Query("from Role r,AdminRole ar where r.roleId = ar.roleId and ar.adminId = ?1")
	List<Role> findRoleByUserId(String userId);
	//@Query("from Role r where r.roleId in (select a.roleId from adminRole a where a.adminId=?1) order by r.createdAt desc")
	@Query("from Role r inner join AdminRole ar on r.roleId = ar.roleId left join Admin a on a.uid = ar.adminId  where a.uid = ?1 and r.enable = 1")
    List<Role> selectRoleListByAdminId(String Id);
	@Query("from Role r where r.enable=?1 ")
    List<Role> findAllByEnable(Integer enable);
}
