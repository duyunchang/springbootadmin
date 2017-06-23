/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.mapper.console;

import com.geekcattle.model.console.Role;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:32
 */
public interface RoleMapper extends JpaRepository<Role,String> {
    Set<String> findRoleByUserId(String userId);
    List<Role> selectRoleListByAdminId(String Id);
    
    List<Role> findAllByEnable(Integer enable);
}
