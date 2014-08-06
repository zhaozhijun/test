package com.erayt.dao.base;

import java.sql.ResultSet;

public interface ResultSetCallBack<T> {
	/**
	 * 
	 * @Title: doResultSet
	 * @Description: ResultSet的回调
	 * @param rs
	 * @return T
	 */
	public T doResultSet(ResultSet rs);
}
