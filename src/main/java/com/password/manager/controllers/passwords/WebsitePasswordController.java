package com.password.manager.controllers.passwords;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.password.manager.entities.WebsitePasswords;
import com.password.manager.services.IPasswordService;
import com.password.manager.util.AppUtils;
import com.password.manager.util.BaseResponseDTO;

@RestController
public class WebsitePasswordController {

	@Autowired
	private IPasswordService passwordService;
	
	@RequestMapping(value = "/app/sites", method = RequestMethod.POST)
	public BaseResponseDTO addNewPassword(@RequestParam("userId") Integer userId, @RequestBody WebsitePasswords passwordToStore) throws Exception {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		try {
			passwordToStore.setUserId(userId);
			passwordToStore.setWeb_pwd(AppUtils.encryptText(passwordToStore.getWeb_pwd()));
			WebsitePasswords storedPassword = passwordService.save(passwordToStore);
			HashMap<String, String> data = new HashMap<>();
			data.put("status", "success");
			baseResponseDTO.setData(data);
		} catch(Exception e) {
			e.printStackTrace();
			baseResponseDTO.setError(e.getMessage());
		}
		return baseResponseDTO;
	}
	
	@RequestMapping(value = "/app/sites/list", method = RequestMethod.GET)
	public BaseResponseDTO getPasswordForUser(@RequestParam("userId") Integer id) throws Exception {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		try {
			if(id == null || id == 0) {
				throw new Exception("The id field cannot be null.");
			}
			List<WebsitePasswords> passwords = passwordService.findAllByUserId(id);
			if(passwords.size() > 0) {
				for(WebsitePasswords pwd: passwords) {
					pwd.setWeb_pwd(AppUtils.decryptText(pwd.getWeb_pwd()));
				}
				baseResponseDTO.setData(passwords);
			} else {
				throw new Exception("You have no stored passwords");
			}
		} catch(Exception e) {
			e.printStackTrace();
			baseResponseDTO.setError(e.getMessage());
		}
		return baseResponseDTO;
	}
	
}
