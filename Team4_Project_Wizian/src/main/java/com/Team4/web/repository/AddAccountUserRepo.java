package com.Team4.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.web.entity.UsersEntity;

public interface AddAccountUserRepo extends JpaRepository<UsersEntity, String>{

}
