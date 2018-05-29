package com.monza.app.monzausers.service;

import com.monza.app.monzausers.exception.UserNotFoundException;
import com.monza.app.monzausers.model.User;

public interface UsersService {

	User save(User user);

	User updateUser(String userId, User user) throws UserNotFoundException;

	void deleteUser(String userId);

	User getUser(String userId) throws UserNotFoundException;

}
