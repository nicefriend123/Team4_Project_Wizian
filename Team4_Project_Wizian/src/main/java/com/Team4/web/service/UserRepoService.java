package com.Team4.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.UsersEntity;
import com.Team4.web.repository.UserRepo;

@Service
public class UserRepoService {
	
	@Autowired
	UserRepo userRepo;
	
	// 전체 행 가져오기
	public List<UsersEntity> doSelectAll() {
		return userRepo.findAll();
	}
	
	//삽입
	public void doInsert(UsersEntity user) {
		userRepo.save(user);
	}


}
