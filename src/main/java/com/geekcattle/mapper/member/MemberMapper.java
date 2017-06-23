/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.mapper.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.geekcattle.model.member.Member;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:32
 */
public interface MemberMapper extends JpaRepository<Member,String> {
	
	@Query("from Member m where m.account = ?1")
    Member selectByUsername(String username);
    
    @Query("from Member m where m.account = ?1")
    List<Member> findByAccount(String account);
}
