package com.monza.app.monzausers.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monza.app.monzausers.model.User;
import com.monza.app.monzausers.repository.UsersRepository;

@Repository
public class UsersDaoImpl implements UsersDao {
	@Autowired
	UsersRepository usersRepository;

	@Override
	public User saveUser(User user) {
		return usersRepository.save(user);
	}

	@Override
	public User getUser(String userId) {
		return usersRepository.findByIdAndDeleted(userId, false);
	}

}
