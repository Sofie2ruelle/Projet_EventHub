package fr.dawan.eventhub.service;

import java.util.List;

import fr.dawan.eventhub.entities.User;

public interface UserService {
	
	List<User> findAllAdmin();
	List<User> findAllUser();
	List<User> findAll();
	Long deleteUser(Long id);
	User createUser(User user);
	User updateUser(User user);
}
