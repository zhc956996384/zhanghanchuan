package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.entity.User;
import com.util.ResponseUtil;

import net.sf.json.JSONObject;

public class UserSaveServlet extends HttpServlet {

	UserDao userDao = new UserDao();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = 0;
		try {
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String qq = request.getParameter("qq");
			// 用于修改用户
			String id = request.getParameter("id");

			User user = new User();
			user.setName(name);
			user.setPhone(phone);
			user.setEmail(email);
			user.setQq(qq);
			if (!"".equals(id) && id != null) {
				user.setId(Integer.parseInt(id));
				i = userDao.updateUser(user);
			} else {
				i = userDao.addUser(user);
			}
			JSONObject result = new JSONObject();
			if (i > 0) {
				result.put("success", "true");
			} else {
				result.put("success", "false");
				result.put("errorMsg", "操作失败!");
			}
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
