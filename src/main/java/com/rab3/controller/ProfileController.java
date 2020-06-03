package com.rab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3.controller.dto.ProfileDTO;
import com.rab3.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	public ProfileController() {
		System.out.println("IN the ProfileController");
	}

	@GetMapping("/search")
	public String search() {
		return "search";
	}

	@PostMapping("/forgotPassword")
	public String forgetPasswordPage(@RequestParam String email, Model model) {
		String passsoword = profileService.forgetPassword(email);
		if (passsoword != null) {
			model.addAttribute("password", "Hello your password is  =  " + passsoword);
		} else {
			model.addAttribute("password", "Sorry!! email is not valid!!!!!!!!!!!!!!!");
		}
		return "forgotPassword";
	}

	@PostMapping("/search")
	public String searchPage(@RequestParam String email, Model model) {
		ProfileDTO profileDTO = profileService.searchEmail(email);
		if (profileDTO != null) {
			model.addAttribute("magic", profileDTO);
		} else {
			model.addAttribute("msg", "Sorry!! email is not valid!!!!!!!!!!!!!!!");
		}

		return "search";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("count", profileService.count());
		return "register";
	}

	@PostMapping("/register")
	public String registerPostPage(@ModelAttribute ProfileDTO profileDTO, Model model) {
		profileService.saveProfile(profileDTO);
		model.addAttribute("count", profileService.count());
		model.addAttribute("msg", "You are successfully registered!!!");
		return "register";
	}

	@GetMapping("/editProfile")
	public String editProfile(@RequestParam int aid, Model model) {
		ProfileDTO profileDTO = profileService.findById(aid);
		model.addAttribute("profileDTO", profileDTO);
		return "editProfile";
	}

	@PostMapping("/updateProfile")
	public String postEditProfile(@ModelAttribute ProfileDTO profileDTO, Model model) {
		profileService.update(profileDTO);
		model.addAttribute("magic", profileDTO);
		model.addAttribute("msg", "Your profile is successfully updated!!");
		return "home";
	}

	@GetMapping("/profiles")
	public String showProfiles(Model model) {
		List<ProfileDTO> profileDTOs = profileService.findAll();
		model.addAttribute("profileDTOs", profileDTOs);
		return "profiles";
	}

	@GetMapping("/deleteProfile")
	public String deleteProfile(@RequestParam String uname, Model model) {
		profileService.deleteByusername(uname);
		model.addAttribute("msg", "profile is successfully deleted!!");
		return "redirect:/profiles";
	}

}