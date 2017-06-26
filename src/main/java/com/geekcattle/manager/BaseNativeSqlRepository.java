package com.geekcattle.manager;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.geekcattle.model.console.Menu;
import com.geekcattle.model.console.Role;
/**
 * 使用原生sql语句 用法
 * */
@Service
public class BaseNativeSqlRepository {
	
	@PersistenceUnit(unitName = "default")
	private EntityManagerFactory emf;

	public void deleteById(String Id){
		EntityManager em = emf.createEntityManager();
		// 定义SQL
		String sql_admin_role="delete from admin_role ar where ar.adminId = ?1";
		String sql_admin="delete from admin a where a.uid = ?1";
		// 创建原生SQL查询QUERY实例		
		Query query_admin_role = em.createNativeQuery(sql_admin_role);
		int execute_admin_role = query_admin_role.executeUpdate();		
		Query query_admin = em.createNativeQuery(sql_admin);
		int execute_admin = query_admin.executeUpdate();
		
		em.close();
				 
	 }
	
	public List<Menu> findMenuCodeByUserId(String userId){
		EntityManager em = emf.createEntityManager();
		// 定义SQL
	    String sql="select m.menu_code from menu m , role_menu rm, admin_role ar where ar.admin_id ="+userId+" and m.menu_id = rm.menu_id and rm.role_id = ar.role_id";
		// order by l.createTime desc";
		// 创建原生SQL查询QUERY实例
		Query query = em.createNativeQuery(sql, Menu.class);

		// 执行查询，返回的是查询属性值数组的集合
		@SuppressWarnings("unchecked")
		List<Menu> objecArraytList = query.getResultList();

		em.close();
		return objecArraytList;
				
	};
	
	public List<Menu> selectMenuByAdminId(String userId){
		EntityManager em = emf.createEntityManager();
		// 定义SQL
	    String sql="select * from menu m left join role_menu rm on m.menu_id = rm.menu_id  left join role r on r.role_id = rm.role_id  left join admin_role ar on r.role_id = ar.role_id  left join admin a on a.uid = ar.admin_id   where a.uid = "+userId+" and r.enable = 1 and m.menu_type &lt;&gt; 'button'  order by m.listorder asc,m.created_at asc";
		// order by l.createTime desc";
		// 创建原生SQL查询QUERY实例
		Query query = em.createNativeQuery(sql, Menu.class);

		// 执行查询，返回的是查询属性值数组的集合
		@SuppressWarnings("unchecked")
		List<Menu> objecArraytList = query.getResultList();

		em.close();
		return objecArraytList;
	};
	
	public List<Menu> selectMenuByRoleId(String roleId){
		EntityManager em = emf.createEntityManager();
		// 定义SQL
	    String sql="select m.* from role_menu rm  left join menu m on rm.menu_id = m.menu_id where rm.role_id="+roleId;
		// order by l.createTime desc";
		// 创建原生SQL查询QUERY实例
		Query query = em.createNativeQuery(sql, Menu.class);

		// 执行查询，返回的是查询属性值数组的集合
		@SuppressWarnings("unchecked")
		List<Menu> objecArraytList = query.getResultList();

		em.close();
		return objecArraytList;
		
	};
	
	public List<Role> selectRoleListByAdminId(String Id){
		EntityManager em = emf.createEntityManager();
		// 定义SQL
	    String sql="select r.role_id ,r.role_name,r.enable,a.uid as adminid,a.username,a.state from role r inner join admin_role ar on r.role_id = ar.role_id left join admin a on a.uid = ar.admin_id  where a.uid = "+ Id+" and r.enable = 1";
		// order by l.createTime desc";
		// 创建原生SQL查询QUERY实例
		Query query = em.createNativeQuery(sql, Role.class);

		// 执行查询，返回的是查询属性值数组的集合
		@SuppressWarnings("unchecked")
		List<Role> objecArraytList = query.getResultList();

		em.close();
		return objecArraytList;
		
	};
	
	public List<Role> findRoleByUserId(String userId){
		EntityManager em = emf.createEntityManager();
		// 定义SQL
	    String sql="select r.role_name from role r,admin_role ar where r.role_id = ar.role_id and ar.admin_id = "+userId;
		// order by l.createTime desc";
		// 创建原生SQL查询QUERY实例
		Query query = em.createNativeQuery(sql, Role.class);

		// 执行查询，返回的是查询属性值数组的集合
		@SuppressWarnings("unchecked")
		List<Role> objecArraytList = query.getResultList();

		em.close();
		return objecArraytList;
		
	};
//	public List<lmtLogMonitorM3u8> getLastSendTaskM3u8(String sql) {
//
//		EntityManager em = emf.createEntityManager();
//		// 定义SQL
//		// String sql="select * from lmt_log_monitor_m3u8 l where "+Othersql+"
//		// order by l.createTime desc";
//		// 创建原生SQL查询QUERY实例
//		Query query = em.createNativeQuery(sql, lmtLogMonitorM3u8.class);
//
//		// 执行查询，返回的是查询属性值数组的集合
//		@SuppressWarnings("unchecked")
//		List<lmtLogMonitorM3u8> objecArraytList = query.getResultList();
//
//		em.close();
//		return objecArraytList;
//	}
//
//	public List<lmtLogMonitorTs> getLastSendTaskTs(String sql) {
//
//		EntityManager em = emf.createEntityManager();
//		// 定义SQL
//		// String sql="select * from lmt_log_monitor_m3u8 l where "+Othersql+"
//		// order by l.createTime desc";
//		// 创建原生SQL查询QUERY实例
//		Query query = em.createNativeQuery(sql, lmtLogMonitorTs.class);
//
//		// 执行查询，返回的是查询属性值数组的集合
//		@SuppressWarnings("unchecked")
//		List<lmtLogMonitorTs> objecArraytList = query.getResultList();
//
//		em.close();
//		return objecArraytList;
//	}

}
