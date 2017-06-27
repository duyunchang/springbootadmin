/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.service.console;

import com.geekcattle.manager.BaseNativeSqlRepository;
import com.geekcattle.manager.console.AdminMapper;
import com.geekcattle.manager.console.MenuMapper;
import com.geekcattle.model.BaseEntity;
import com.geekcattle.model.console.Admin;
import com.geekcattle.model.console.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:43
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;
    
    @Autowired
    private BaseNativeSqlRepository  BaseNativeSqlManager;
    
    @Autowired 
    private BaseEntity baseEntity;

    public List<Menu> getPageList(Menu menu) {
    	
    	List<Order> orders=new ArrayList<>();
		Order orderc=new Order(Sort.Direction.DESC, "createdAt");
		Order orderl=new Order(Sort.Direction.ASC, "listorder");
		orders.add(orderl);
		orders.add(orderc);
		Sort sort = new Sort(orders);  
		
    	Pageable pageable = new PageRequest(baseEntity.getOffset(), baseEntity.getLimit(), sort); 
    	Page<Menu> findAll = menuMapper.findAll(pageable);
    	
    	return findAll.getContent();
    	
        //PageHelper.offsetPage(menu.getOffset(), menu.getLimit(), "listorder asc, created_at desc");
        //return menuMapper.selectAll();
    }

    public List<Menu> getMenuAll(){
    	//Sort sort = new Sort(Sort.Direction.ASC, "listorder");  
    	List<Order> orders=new ArrayList<>();
		Order orderc=new Order(Sort.Direction.DESC, "createdAt");
		Order orderl=new Order(Sort.Direction.ASC, "listorder");
		orders.add(orderl);
		orders.add(orderc);
		Sort sort = new Sort(orders);  
        //PageHelper.orderBy("listorder asc, created_at desc");
    	
        return menuMapper.findAll(sort);
    }

    public List<Menu> getMenuList(Example example){
        //PageHelper.orderBy("listorder asc, created_at desc");
    	
		List<Order> orders=new ArrayList<>();
		Order orderc=new Order(Sort.Direction.DESC, "createdAt");
		Order orderl=new Order(Sort.Direction.ASC, "listorder");
		orders.add(orderl);
		orders.add(orderc);
    	Sort sort = new Sort(orders);  
        
        return menuMapper.findAll(sort); 
    }

    public List<Menu> selectByParentMenuList(String parentId){
        //new Example(Menu.class, null);
        //example.createCriteria().andCondition("parent_id = ", parentId);
        //PageHelper.orderBy("listorder asc, created_at desc");
        List<Order> orders=new ArrayList<>();
		Order orderc=new Order(Sort.Direction.DESC, "createdAt");
		Order orderl=new Order(Sort.Direction.ASC, "listorder");
		orders.add(orderl);
		orders.add(orderc);
		
    	Sort sort = new Sort(orders);  
        return menuMapper.findAll(sort);
    }


    public Integer getCount(String parent_id){
    	
    	return  menuMapper.findByParentId(parent_id).size();
    	 
        //return menuMapper.selectCountByExample(example);
    }

    public Menu getById(String id) {
        return menuMapper.findOne(id);
    }

    @Transactional
    public void deleteById(String id) {
        menuMapper.delete(id);
    }

    @Transactional
    public void insert(Menu menu){
        menuMapper.save(menu);
    }

    @Transactional
    public void save(Menu menu) {
    	menuMapper.save(menu);
//        if (menu.getMenuId() != null) {
//            menuMapper.updateByPrimaryKey(menu);
//        } else {
//            menuMapper.insert(menu);
//        }
    }

    public Set<String> findMenuCodeByUserId(String userId) {
    	//主页list不能重复
    	List<String> list= BaseNativeSqlManager.findMenuCodeByUserId(userId);    	
    	Set<String> set= new HashSet<String>();
        set.addAll(list);
//    	Set<String>  set=new HashSet<String>();
//    	for(String menu:list){
//    		set.add(menu.);
//    		
//    	}
    	return set;
    }

    public Set<String> getAllMenuCode() {
//    	List<Menu> findAll = menuMapper.findAll();
//    	Set<String>  set=new HashSet<String>();
//    	for(Menu menu:findAll){
//    		
//    		set.add(menu.getMenuCode());
//    	}
    	Set<String>  set=menuMapper.getALLMenuCode();
    	
        return set;
    }

    public List<Menu> getComboTree(Menu menu) {
        return menuMapper.findAll();
    }

    public List<Menu> selectMenuByAdminId(String userId){
        return BaseNativeSqlManager.selectMenuByAdminId(userId);
    }

    public List<Menu> selectAllMenu(){
        return menuMapper.findAll();
    }

    public List<Menu> selectMenuByRoleId(String roleId){
        return BaseNativeSqlManager.selectMenuByRoleId(roleId);
    }

    @Transactional
    public void update(Menu menu, String id ){
    	
    	menuMapper.updatelistorderByid(menu.getListorder(),  id);
    	
        //menuMapper.updateByExampleSelective(menu, example);
    }

    public List<Menu> getChildMenuList(ArrayList<Menu> menuLists ,String parentId){
        //Example example = new Example(Menu.class);
        //example.createCriteria().andCondition("parent_id = ", parentId);
        //PageHelper.orderBy("listorder asc, created_at desc");
        //List<Menu> List = menuMapper.selectByExample(example);
       
    	List<Menu> List = menuMapper.findByParentId( parentId);
        for(Menu menu : List){
            menuLists.add(menu);
            /*if(menu.getChildNum() > 0){

            }*/
            getChildMenuList(menuLists, menu.getMenuId());

        }
        return menuLists;
    }

}
