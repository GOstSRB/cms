package no.service;

import java.util.List;

import org.springframework.data.domain.Page;

import no.model.User;

public interface UserService {
	
	User save(User user);
	
	User remove(Long id);
	
	User findOne(Long id);

	Page<User> findAll(int page);

	List<User> findAll();

	User findByUserNameAndPassword(String userName, String password);

}
