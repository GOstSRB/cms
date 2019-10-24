package no.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.service.UserService;
import no.support.UserDTOToUser;
import no.support.UserToUserDTO;

@RestController
@RequestMapping(value="/api/logins")
public class ApiLoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserToUserDTO toDTO;
	
	@Autowired
	private UserDTOToUser toUser;
	
	
}
