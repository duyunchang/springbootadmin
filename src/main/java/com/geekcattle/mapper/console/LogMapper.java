/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.mapper.console;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geekcattle.model.console.Log;

/**
 * author geekcattle
 * date 2017/1/6 0006 上午 11:25
 */
public interface LogMapper  extends JpaRepository<Log ,String> {
}
