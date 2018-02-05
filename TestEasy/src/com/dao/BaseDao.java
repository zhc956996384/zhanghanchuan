package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBUtil;
/**
 * 数据库连接与关闭工具类。
 * @author 北大青鸟
 */
public class BaseDao {
	protected Connection conn =null;
	protected PreparedStatement pstmt = null;

	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		// 若结果集对象不为空，则关闭
		if (rs != null) {
			try {
				rs.close();
				System.out.println("关闭了rs:"+rs.hashCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若Statement对象不为空，则关闭
		if (pstmt != null) {
			try {
				System.out.println("1关闭了pstmt:"+pstmt.hashCode());
				pstmt.close();
				System.out.println("2关闭了pstmt:"+pstmt.hashCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若数据库连接对象不为空，则关闭
		if (conn != null) {
			try {
				conn.close();
				System.out.println("关闭了conn:"+conn.hashCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 增、删、改操作
	 * @param sql sql语句
	 * @param prams 参数数组
	 * @return 执行结果
	 */
	public int exceuteUpdate(String preparedSql, Object... param) {
		int num = 0;
		try {
			conn = DBUtil.getConnection();
			System.out.println("BaseDao从中DBUtil获取了一个conn:"+conn.hashCode());
			pstmt = conn.prepareStatement(preparedSql);
			System.out.println("BaseDao获取了一个pstmt:"+pstmt.hashCode());
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					// 为预编译sql设置参数
					pstmt.setObject(i + 1, param[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return num;
	}
	
	public ResultSet executeQuery(String sql, Object... params) {
        ResultSet rs = null;
        try {
        	conn = DBUtil.getConnection();
        	System.out.println("BaseDao从中DBUtil获取了一个conn:"+conn.hashCode());
            pstmt = conn.prepareStatement(sql);
            System.out.println("BaseDao获取了一个pstmt:"+pstmt.hashCode());
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
            System.out.println("BaseDao获取了一个rs:"+rs.hashCode());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
        //关闭资源不放在这里,因为我们要用到RS.
        //如果此时关闭了RS则结果集中的资源就丢失了.
    }
	
	public static void main(String[] args) throws Exception {
		DBUtil dbUtil = new DBUtil();
		Connection conn =dbUtil.getConnection();
		if (conn!=null) {
			System.out.println("连接数据库成功!");
		}
	}
}
