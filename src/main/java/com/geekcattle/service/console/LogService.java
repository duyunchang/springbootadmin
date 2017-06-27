/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.service.console;

import com.geekcattle.manager.console.LogMapper;
import com.geekcattle.model.BaseEntity;
import com.geekcattle.model.console.AdminRole;
import com.geekcattle.model.console.Log;
import com.geekcattle.util.CamelCaseUtil;
import com.geekcattle.util.DateUtil;
import com.geekcattle.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author geekcattle
 * date 2017/1/6 0006 上午 11:26
 */
@Service
public class LogService {

    @Autowired
    private LogMapper logMapper;
    
    @Autowired 
    private BaseEntity baseEntity;

    public List<Log> getPageList(Log log) {
    	Sort sort = new Sort(Sort.Direction.DESC, "logTime");  
    	Pageable pageable = new PageRequest(baseEntity.getOffset(), baseEntity.getLimit(), sort); 
    	
        return logMapper.findAll(pageable).getContent();
        
//        PageHelper.offsetPage(log.getOffset(), log.getLimit(), CamelCaseUtil.toUnderlineName(log.getSort())+" "+log.getOrder());
//        return logMapper.selectAll();
    }

    @Transactional
    public void insert(Log log){
        logMapper.save(log);
    }
    
    public void insertLoginLog(String username, String ip, String action){
        Log  log = new Log();
        log.setLogId(UuidUtil.getUUID());
        log.setLogUser(username);
        log.setLogTime(DateUtil.getCurrentTime());
        log.setLogIp(ip);
        log.setLogAction(action);
        this.insert(log);
    }


}
