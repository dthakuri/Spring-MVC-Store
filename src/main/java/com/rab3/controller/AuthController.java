package com.rab3.controller;

import com.rab3.dao.ProfileDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3.controller.dto.ProfileDTO;

@Controller
public class AuthController {
	
	@Autowired
	private ProfileDao profileDao;
	
	public AuthController() {
		System.out.println("IN the AuthController");
	}
	
	@GetMapping("/foo")
	public String helloWorld() {
		return "hello";   //   /aha.jsp
	}
	
	@GetMapping({"/auth","/login","/","index"})
	public String showLogin() {
		 return "login";
	}
	
	
	@PostMapping("/auth")
	public String auth(@RequestParam String username,@RequestParam String password,Model model) {
		List<ProfileDTO> profileDTOs= profileDao.authLogin(username, password);
		if(profileDTOs.size()==1) {
				model.addAttribute("magic", profileDTOs.get(0));
				return "home"; 
			}else {
				model.addAttribute("msg", "Sorry!! username and password are not valid!!!!!!!!!!!!!!!");
				return "login";
			}


	}

}