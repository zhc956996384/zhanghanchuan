package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.util.PageBean;

public class UserDao extends BaseDao{

	public List<User> getAllUsersByPage(PageBean pageBean) {
		List<User> users = new ArrayList<User>();
		StringBuffer sql = new StringBuffer("select * from t_user2");
		sql = sql.append(" limit " + pageBean.getStart() + "," + pageBean.getPageSize());
		ResultSet rs =null;
		try {
			rs = this.executeQuery(sql.toString());
			System.out.println("UserDao中的getAllUsersByPage()方法获取了BaseDao传过来的rs:"+rs.hashCode());
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setQq(rs.getString("qq"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pstmt, rs);
			if(conn==null){
				System.out.println("conn关闭..");
			}
		}
		return users;
	}

	public int getUserCount() {
		int count = 0;
		String sql = "select count(1) from t_user2";
		ResultSet rs = this.executeQuery(sql);
		System.out.println("UserDao中的getUserCount()方法获取了BaseDao传过来的rs:"+rs.hashCode());
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
			if(conn==null){
				System.out.println("conn关闭..");
			}
		}
		return count;
	}
	
	
	public int addUser(User user){
		int count = 0;
		String sql = "insert into t_user2 values(null,?,?,?,?)";
		Object[] params = {user.getName(),user.getPhone(),user.getEmail(),user.getQq()};
		count = this.exceuteUpdate(sql, params);
		return count;
	}
	
	public int updateUser(User user){
		int count = 0;
		String sql = "update t_user2 set name=?,phone=?,email=?,qq=? where id=?";
		Object[] params = {user.getName(),user.getPhone(),user.getEmail(),user.getQq(),user.getId()};
		count = this.exceuteUpdate(sql, params);
		return count;
	}
	
	public int delUser(String id){
		String sql = "delete from t_user2 where id= ?";
		Object[] params = {id};
		int i =this.exceuteUpdate(sql, params);
		return i ;
	}

	public static void main(String[] args) throws Exception {
		UserDao dao = new UserDao();
		System.out.println(dao.getUserCount());
//		PageBean pageBean = new PageBean(1, 10);
//		List<User> users = dao.getAllUsersByPage(pageBean);
//		for (User user : users) {
//			System.out.println(user.getName());
//		}

	}

}
