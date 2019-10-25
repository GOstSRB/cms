package no.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import no.model.User;
import no.web.dto.UserDTO;

@Component
public class UserToUserDTO implements Converter<User, UserDTO>{

	@Override
	public UserDTO convert(User user) {
UserDTO dto = new UserDTO();
		
		dto.setId(user.getId());
		dto.setFirstname(user.getFirstName());
		dto.setLastname(user.getLastName());
		dto.setEmail(user.getEmail());
		dto.setUsername(user.getUserName());
//		dto.setPassword(user.getPassword());
		
		dto.setTypeOfUser(user.getTypeOfUser());
		dto.setPhone(user.getPhone());
		dto.setMisc1(user.getMisc1());
		dto.setMisc2(user.getMisc2());
		dto.setMisc3(user.getMisc3());
		dto.setTeamMemberSince(user.getTeamMemberSince());
		dto.setCurrentWageHr(user.getCurrentWageHr());
		dto.setCurrentWageAnnual(user.getCurrentWageAnnual());
		dto.setVacation(user.getVacation());
		dto.setSick(user.getSick());
		
		return dto;
	}
	public List<UserDTO> convert(List<User> users){
		List<UserDTO> ret = new ArrayList<>();
		
		for(User user : users){
			ret.add(convert(user));
		}
		
		return ret;
	}

}
