package com.rab3.dao;

import java.util.List;

import com.rab3.controller.dto.ProfileDTO;

public interface ProfileDao {

	String forgetPassword(String email);

	String saveProfile(ProfileDTO profileDTO);

	ProfileDTO findById(int aid);

	String update(ProfileDTO profileDTO);

	List<ProfileDTO> findAll();

	List<ProfileDTO> authLogin(String username, String password);

	int count();

	ProfileDTO search(String email);

	String deleteByusername(String username);

}