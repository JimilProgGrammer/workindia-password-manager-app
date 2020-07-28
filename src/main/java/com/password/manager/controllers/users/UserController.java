package com.password.manager.controllers.users;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.password.manager.entities.Users;
import com.password.manager.services.IUserService;
import com.password.manager.util.AppUtils;
import com.password.manager.util.BaseResponseDTO;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/app/user", method = RequestMethod.POST)
	public BaseResponseDTO registerUser(@RequestBody Users user) throws Exception {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		try {
			Optional<Users> existingUser = userService.findByUsername(user.getUsername());
			if(existingUser.isPresent()) {
				throw new Exception("User is already registered.");
			}
			user.setId(1);
			user.setPwd(AppUtils.encryptText(user.getPwd()));
			Users savedUser = userService.save(user);
			HashMap<String, String> response = new HashMap<>();
			response.put("status", "account created");
			baseResponseDTO.setData(response);
		} catch(Exception e) {
			e.printStackTrace();
			baseResponseDTO.setError(e.getMessage());
		}
		return baseResponseDTO;
	}
	
	@RequestMapping(value = "/app/user/auth", method = RequestMethod.POST)
	public BaseResponseDTO loginUser(@RequestBody Users user) throws Exception {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		try {
			Optional<Users> existingUser = userService.findByUsername(user.getUsername());
			if(existingUser.isPresent()) {
				Users dbUser = existingUser.get();
				if(dbUser.getPwd().equals(AppUtils.encryptText(user.getPwd()))) {
					HashMap<String, Object> response = new HashMap<>();
					response.put("status", "success");
					response.put("userId", dbUser.getId());
					baseResponseDTO.setData(response);
				}  else {
					throw new Exception("Invalid login credentials");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			baseResponseDTO.setError(e.getMessage());
		}
		return baseResponseDTO;
	}
	
}
