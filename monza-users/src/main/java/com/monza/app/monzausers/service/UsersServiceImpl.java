package com.monza.app.monzausers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monza.app.monzausers.dao.UsersDao;
import com.monza.app.monzausers.exception.UserNotFoundException;
import com.monza.app.monzausers.model.User;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersDao usersDao;

	@Override
	public User save(User user) {
		User model = null;
		if (user != null) {
			model = usersDao.saveUser(user);
		}
		return model;
	}

	@Override
	public User updateUser(String userId, User user) throws UserNotFoundException {
		User model = null;
		if (userId != null) {
			model = getUser(userId);
			user.setId(model.getId());
			user.setPassword(model.getPassword());
			model = usersDao.saveUser(user);
		}
		return model;
	}

	@Override
	public void deleteUser(String userId) {
		if (userId != null) {
			try {
				User user = getUser(userId);
				user.setDeleted(true);
				usersDao.saveUser(user);
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public User getUser(String userId) throws UserNotFoundException {
		User user = null;
		if (userId != null) {
			user = usersDao.getUser(userId);
			if (user == null) {
				throw new UserNotFoundException();
			}
		}
		return user;

	}

}
