package com.niit.BackEnd.dao;

import java.util.List;

import com.niit.BackEnd.model.Users;




public interface UsersDao {
	
	public boolean saveorupdate(Users users);
	
	public boolean delete (Users users);
	
	public Users getUsers(String uId);
	
	
	public List<Users> list();


}
