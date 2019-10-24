package no.service;

import org.springframework.data.domain.Page;

import no.model.User;

public interface UserService {
	
	User save(User user);
	
	User remove(Long id);
	
	User findOne(Long id);

	Page<User> findAll(int page);


}
