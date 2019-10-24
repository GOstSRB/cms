package no.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import no.model.User;
import no.repository.UserRepository;
import no.service.UserService;

@Service
public class JpaUserService implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User remove(Long id) {
		// TODO Auto-generated method stub
		User user = userRepository.findOne(id);
		if(user !=null) {
		userRepository.delete(user);
		}
		return user;
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(int page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
