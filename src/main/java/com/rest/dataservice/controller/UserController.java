package com.rest.dataservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataservice.config.TokenUtil;
import com.rest.dataservice.entity.UserAuth;
import com.rest.dataservice.model.TokenRequest;
import com.rest.dataservice.model.TokenResponse;
import com.rest.dataservice.service.UserService;

/**
 * @author Kamal
 *
 */


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private static final String LOGIN = "/login";

	private static final String REGISTER = "/register";

	private static final String USER_DISABLED = "User Disabled";

	private static final String INVALID_CREDENTIAL = "Invalid Credential";


	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenUtil tokenUtil;

	/**
	 * @param authenticationRequest
	 * @return ResponseEntity User logged in
	 * @throws Exception
	 */
	@RequestMapping(value = LOGIN, method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody TokenRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = tokenUtil.generateToken(userDetails);
		HttpStatus status=HttpStatus.ACCEPTED;

		return ResponseEntity.ok(new TokenResponse(token));
	}
	
	/**
	 * @param user
	 * @return ResponseEntity registerd user data
	 * @throws Exception
	 */
	@RequestMapping(value = REGISTER, method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserAuth user) throws Exception {
		return ResponseEntity.ok(userService.save(user));
	}

	/**
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception(USER_DISABLED, e);
		} catch (BadCredentialsException e) {
			throw new Exception(INVALID_CREDENTIAL, e);
		}
	}
	

	

}
