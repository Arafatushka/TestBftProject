package com.bfrcom.DAO;

import com.bfrcom.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserDAO extends CrudRepository<User, Long>, QueryByExampleExecutor<User> {
}
