package com.monza.app.monzausers.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.monza.app.monzausers.model.User;

public interface UsersRepository extends MongoRepository<User, String> {

	User findByIdAndDeleted(String userId, boolean deleted);

}
