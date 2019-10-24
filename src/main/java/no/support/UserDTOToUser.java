package no.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import no.model.User;
import no.service.UserService;
import no.web.dto.UserDTO;

@Component
public class UserDTOToUser implements Converter<UserDTO, User>{

	@Autowired
	private UserService userService;
	
	@Override
	public User convert(UserDTO dto) {
		User user = null;
		if(dto.getId()==null){
			user = new User();
		}else{
			user = userService.findOne(dto.getId());
			if(user == null){
				throw new IllegalStateException("Editing non-existant User");
			}
		}
		user.setEmail(dto.getEmail());
		user.setUserName(dto.getUsername());
		user.setFirstName(dto.getFirstname());
		user.setLastName(dto.getLastname());
		
		return user;
	}
	
	public List<User> convert(List<UserDTO> usersDTO){
		List<User> ret = new ArrayList<>();
		
		for(UserDTO dto: usersDTO){
			ret.add(convert(dto));
		}
		
		return ret;
	}	
}
