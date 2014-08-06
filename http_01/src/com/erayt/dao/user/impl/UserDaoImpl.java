package com.erayt.dao.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.erayt.bean.User;
import com.erayt.common.Page;
import com.erayt.dao.base.BaseDao;
import com.erayt.dao.base.ResultSetCallBack;
import com.erayt.dao.user.UserDao;
import com.erayt.dto.UserDto;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public void addUser(User user) {
		String sql = "insert into t_user(userId,userName,password) values(?,?,?)";
		Object[] params = new Object[] { user.getId(), user.getName(),
				user.getPassword() };
		executeUpdate(sql, params);
	}

	@Override
	public void updateUser(User user) {
		String sql = "update base_user set userName=?,pwd=? where userId=?";
		Object[] params = new Object[] { user.getName(), user.getPassword(),
				user.getId() };
		executeUpdate(sql, params);
	}

	@Override
	public void deleteUser(Integer id) {
		String sql = "delete from base_user  where userId=?";
		Object[] params = new Object[] { id };
		executeUpdate(sql, params);
	}

	@Override
	public List<User> queryUser(UserDto userDto, Page page) {
		StringBuffer sql = new StringBuffer(
				"select userId,userName,pwd from base_user where 1=1 ");
		if (StringUtils.isNotBlank(userDto.getName())) {
			sql.append(" and userName like ").append("'%")
					.append(userDto.getName()).append("%'");
		}
		return null;
	}

	@Override
	public List<User> queryUser(UserDto userDto) {
		StringBuffer sql = new StringBuffer(
				"select userId,userName,pwd from base_user where 1=1 ");
		List<Object> paramList = new ArrayList<Object>();
		if (StringUtils.isNotBlank(userDto.getName())) {
			sql.append(" and userName like ").append("'%").append("?")
					.append("%'");
			paramList.add(userDto.getName());
		}
		return executeQuery(sql.toString(), paramList.toArray(),
				new ResultSetCallBack<List<User>>() {

					@Override
					public List<User> doResultSet(ResultSet rs) {
						List<User> list = new ArrayList<User>();
						try {
							while (rs.next()) {
								User user = new User();
								user.setId(rs.getInt("userId"));
								user.setName(rs.getString("userName"));
								user.setPassword(rs.getString("pwd"));
								list.add(user);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						return list;
					}

				});
	}
}
