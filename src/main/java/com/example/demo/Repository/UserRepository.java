package com.example.demo.Repository;

import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByEmail(String email);

}
