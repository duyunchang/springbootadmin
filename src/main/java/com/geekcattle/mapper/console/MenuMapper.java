/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.mapper.console;

import com.geekcattle.model.console.Menu;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuMapper extends JpaRepository<Menu,String> {
    Set<String> findMenuCodeByUserId(String userId);
    //Set<String> getALLMenuCode();
    List<Menu> selectMenuByAdminId(String userId);
    List<Menu> selectAllMenu();
    List<Menu> selectMenuByRoleId(String roleId);
    
    List<Menu> findByParentId(String parent_id);
    
    int updatelistorderByid(Integer listorder, String id);
}