package com.alejandro.rest.webservices.restful.web.services.jpa;

import com.alejandro.rest.webservices.restful.web.services.user.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
