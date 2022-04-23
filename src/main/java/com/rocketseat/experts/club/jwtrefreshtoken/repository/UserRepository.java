package com.rocketseat.experts.club.jwtrefreshtoken.repository;

import com.rocketseat.experts.club.jwtrefreshtoken.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


}