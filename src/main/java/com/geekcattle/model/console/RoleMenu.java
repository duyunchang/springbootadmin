/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.model.console;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "role_menu")
public class RoleMenu implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7743398050165471673L;

	@Id
    @Column(name = "role_id")
    private String roleId;

    @Id
    @Column(name = "menu_id")
    private String menuId;

    /**
     * @return role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return menu_id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}