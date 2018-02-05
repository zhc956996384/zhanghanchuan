package com.web;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.entity.User;
import com.dao.UserDao;
import com.util.JsonUtil;
import com.util.PageBean;
import com.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserListServlet extends HttpServlet {
	
	UserDao userDao = new UserDao();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
		String pageNo=request.getParameter("page");  
        String pageSize=request.getParameter("rows");
        System.out.println("当前页号:"+pageNo);
        System.out.println("每页显示:"+pageSize);
        try {
			PageBean pageBean = new PageBean(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
			//用于向客户端发回JSON格式的响应
			JSONObject result=new JSONObject();
			List<User> userList = userDao.getAllUsersByPage(pageBean);
			String jsonArray = JSON.toJSONString(userList);
			System.out.println("jsonArray: "+jsonArray);
			//页面中还要显示总共多少记录数.
			int total = userDao.getUserCount();
			result.put("rows", jsonArray);
			result.put("total", total);
			System.out.println("result:"+result.toString());
			ResponseUtil.write(response, result);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
