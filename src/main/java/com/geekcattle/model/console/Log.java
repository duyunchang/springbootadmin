/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.model.console;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geekcattle.model.BaseEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * author geekcattle
 * date 2017/1/6 0006 上午 11:21
 */
@Entity
@Table(name="log")
public class Log  extends BaseEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6029055483747416629L;

	@Id
    @Column(name = "log_id")
    //@GeneratedValue(generator = "UUID")
	@GeneratedValue
    private String logId;

    @Column(name = "log_user")
    private String logUser;
    @Column(name = "log_time")
    private String logTime;
    @Column(name = "log_ip")
    private String logIp;
    @Column(name = "log_action")
    private String logAction;

    @Transient
    @JsonIgnore
    private String sort = "";

    @Transient
    @JsonIgnore
    private String order = "";

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", logUser='" + logUser + '\'' +
                ", logTime='" + logTime + '\'' +
                ", logIp='" + logIp + '\'' +
                ", logAction='" + logAction + '\'' +
                '}';
    }
}
