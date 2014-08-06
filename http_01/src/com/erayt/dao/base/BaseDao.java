package com.erayt.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.erayt.dao.util.DbUtils;

public class BaseDao {
	/**
	 * 
	 * @Title: executeUpdate
	 * @Description: 通用的增、删、改
	 * @param sql
	 * @param objects
	 */
	public void executeUpdate(String sql, Object... objects) {
		Connection con = DbUtils.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(con!=null&&!con.isClosed()){
					 con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @Title: executeQuery
	 * @Description: 通用的查询
	 * @param sql
	 * @param params
	 * @param rsCallBack
	 * @return T
	 */
	public <T> T executeQuery(String sql, Object[] params,
			ResultSetCallBack<T> rsCallBack) {
		Connection con = DbUtils.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			ResultSet rs = ps.executeQuery();
			return rsCallBack.doResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
