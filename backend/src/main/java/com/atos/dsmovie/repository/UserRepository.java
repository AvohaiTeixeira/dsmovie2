package com.atos.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
