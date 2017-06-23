/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.mapper.console;

import com.geekcattle.model.console.Menu;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MenuMapper extends JpaRepository<Menu,String> {
	
	//@Query("select l.menuCode from Menu l where l.menuId in( select r.menuId roleMenu r  where r.roleId in (select a.roleId from  adminRole a where a.adminId=?1 ))")
    
	@Query("from Menu m , RoleMenu rm, AdminRole ar where ar.adminId =?1 and m.menuId = rm.menuId and rm.roleId = ar.roleId")
	List<Menu> findMenuCodeByUserId(String userId);
    //Set<String> getALLMenuCode();
	
	//@Query("from Menu l where l.menuId in( select r.menuId roleMenu r  where r.roleId in (select a.roleId from  adminRole a where a.adminId=?1 ))")
	@Query("from Menu m left join RoleMenu rm on m.menuId = rm.menuId  left join Role r on r.roleId = rm.roleId  left join AdminRole ar on r.roleId = ar.roleId  left join Admin a on a.uid = ar.adminId   where a.uid = ?1 and r.enable = 1 and m.menuType <> 'button' order by m.listorder asc,m.createdAt asc")
	List<Menu> selectMenuByAdminId(String userId);
    //List<Menu> selectAllMenu();
	@Query("from RoleMenu rm  left join Menu m on rm.menuId = m.menuId where rm.roleId=?1")
	//@Query("from Menu l where l.menuId in( select r.menuId roleMenu r  where r.roleId =?1 )")
    List<Menu> selectMenuByRoleId(String roleId);
    
	@Query("from Menu l where l.parentId=?1")
    List<Menu> findByParentId(String parent_id);
    
    @Modifying 
    @Query("update  Menu l  set l.listorder =?1  where l.menuId=?2")
   // @Query("from Menu l where l.parentId=?1")
    int updatelistorderByid(Integer listorder, String id);
}