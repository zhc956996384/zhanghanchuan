package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.util.ResponseUtil;

import net.sf.json.JSONObject;

public class UserDeleteServlet extends HttpServlet{
	
	UserDao userDao = new UserDao();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String delIds=request.getParameter("delId");
			System.out.println("要删除的数据主键为:"+delIds);
			JSONObject result=new JSONObject();
			int nums = userDao.delUser(delIds);
			if(nums>0){
				result.put("success", "true");
				result.put("delNums", nums);
			}else{
				result.put("errorMsg", "删除失败!");
			}
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
