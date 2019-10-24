package no.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		return userRepository.save(user);
	}

	@Override
	public User remove(Long id) {
		User user = userRepository.findOne(id);
		if(user !=null) {
		userRepository.delete(user);
		}
		return user;
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public Page<User> findAll(int page) {
		// TODO Auto-generated method stub
		return userRepository.findAll(new PageRequest(page, 10));
	}

}
