/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.service.member;

import com.geekcattle.mapper.member.MemberMapper;
import com.geekcattle.model.console.Admin;
import com.geekcattle.model.member.Member;
import com.geekcattle.util.CamelCaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author geekcattle
 * date 2017/3/23 0023 上午 11:25
 */
@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<Member> getPageList(Member member) {
    	Sort sort = new Sort(Sort.Direction.DESC, "created_at");  
    	Pageable pageable = new PageRequest(member.getOffset(), member.getLimit(), sort); 
    	return memberMapper.findAll(pageable).getContent();
        //PageHelper.offsetPage(member.getOffset(), member.getLimit(), CamelCaseUtil.toUnderlineName(member.getSort())+" "+member.getOrder());
        //return memberMapper.selectAll();
    }

    public Integer getCount(String account){
    	return memberMapper.findByAccount(account).size();
        //return memberMapper.selectCountByExample(example);
    }

    public Member findByUsername(String username) {
        return memberMapper.selectByUsername(username);
    }

    public void insert(Member member){
        memberMapper.save(member);
    }
}
