package com.erayt.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
	/**
	 * 加载驱动
	 */
	static {
		try {
			Class.forName(ConfigManager.getProperty(ConfigManager.DRIVER));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Title: getConnection 
	 * @Description: 获得连接
	 * @return Connection
	 */
	public static Connection getConnection(){
		Connection con=null;
		try {
			con=DriverManager.getConnection(ConfigManager.getProperty(ConfigManager.URL), ConfigManager.getProperty(ConfigManager.USERNAME), ConfigManager.getProperty(ConfigManager.PASSWORD));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * 
	 * @Title: closeConnection 
	 * @Description: 关闭连接
	 * @param rs
	 * @param st
	 * @param con
	 */
	public static void closeConnection(ResultSet rs,Statement st,Connection con){
		try {
			if(null!=rs){
				rs.close();
			}
			if(null!=st){
				st.close();
			}
			if(null!=con){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
