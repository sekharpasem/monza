package com.monza.app.monzausers.dao;

import com.monza.app.monzausers.model.User;

public interface UsersDao {

	User saveUser(User user);

	User getUser(String userId);

}
