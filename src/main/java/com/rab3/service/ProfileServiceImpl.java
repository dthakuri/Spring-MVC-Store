package com.rab3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3.controller.dto.ProfileDTO;
import com.rab3.dao.ProfileDao;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;

	@Override
	public String forgetPassword(String email) {
		String result = profileDao.forgetPassword(email);
		return result;
	}

	@Override
	public String saveProfile(ProfileDTO profileDTO) {
		String result = profileDao.saveProfile(profileDTO);
		return result;
	}

	@Override
	public ProfileDTO findById(int aid) {
		ProfileDTO result = profileDao.findById(aid);
		return result;
	}

	@Override
	public String update(ProfileDTO profileDTO) {
		String result = profileDao.update(profileDTO);
		return result;
	}

	@Override
	public List<ProfileDTO> findAll() {
		List<ProfileDTO> result = profileDao.findAll();
		return result;
	}

	@Override
	public List<ProfileDTO> authLogin(String username, String password) {
		List<ProfileDTO> result = profileDao.authLogin(username, password);
		return result;
	}

	@Override
	public int count() {
		int result = profileDao.count();
		return result;
	}

	@Override
	public ProfileDTO searchEmail(String email) {
		ProfileDTO result = profileDao.search(email);
		return result;
	}

	@Override
	public String deleteByusername(String username) {
		String result = profileDao.deleteByusername(username);
		return result;
	}

	@Override
	public byte[] findPhotoById(int aid) {
		byte[] photo=profileDao.findPhotoById(aid);
		return photo;
	}

}
