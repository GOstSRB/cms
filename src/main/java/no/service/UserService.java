package no.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import no.model.User;

public interface UserService {
	
	User save(User user);
	
	User remove(Long id);
	
	User findOne(Long id);

	Page<User> findAll(int page);

	List<User> findAll();

	User findByUserNameAndPassword(String userName, String userFirstName);
	
	Page<User> search (String userName, String firstName,String lastName, int page);
	

}
