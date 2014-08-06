package com.erayt.dao.user;

import java.util.List;

import com.erayt.bean.User;
import com.erayt.common.Page;
import com.erayt.dto.UserDto;

public interface UserDao {
	/**
	 * 
	 * @Title: addUser 
	 * @Description: 添加用户
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 
	 * @Title: updateUser 
	 * @Description: 修改用户
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 
	 * @Title: deleteUser 
	 * @Description: 删除用户
	 * @param id
	 */
	void deleteUser(Integer id);
	/**
	 * 
	 * @Title: queryUser 
	 * @Description: 查询用户列表(含分页)
	 * @param userDto
	 * @param page
	 * @return List<User>
	 */
	List<User> queryUser(UserDto userDto,Page page);
	/**
	 * 
	 * @Title: queryUser 
	 * @Description: 查询用户列表(不含分页)
	 * @param userDto
	 * @return List<User>
	 */
	List<User> queryUser(UserDto userDto);
}
