package no.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import no.model.User;
import no.service.UserService;
import no.support.UserDTOToUser;
import no.support.UserToUserDTO;
import no.web.dto.UserDTO;

@RestController
@RequestMapping(value="/api/logins")
public class ApiLoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserToUserDTO toDTO;
	
	@Autowired
	private UserDTOToUser toUser;
	
	
	// this is not in use!!!!! just test
//	@RequestMapping(method=RequestMethod.GET) public ResponseEntity<List<UserDTO>> getUsers() {
//	return new ResponseEntity<> (toDTO.convert(userService.findAll()), HttpStatus.OK);
//}
	
// @Validated insert
	@RequestMapping(method=RequestMethod.GET,
			consumes="application/json")
public ResponseEntity<UserDTO> get(@Validated @RequestBody UserDTO newUser){
		if(newUser.getUsername() == null
		|| newUser.getUsername().isEmpty()
		|| newUser.getPassword() == null 
		|| newUser.getPassword().isEmpty()
				){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
User user = userService.findByUserNameAndPassword(newUser.getUsername(), newUser.getPassword());
if (user != null) {
	return new ResponseEntity<>(
//			toDTO.convert(newUser), 
			HttpStatus.ACCEPTED);
	}
	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}
	}


