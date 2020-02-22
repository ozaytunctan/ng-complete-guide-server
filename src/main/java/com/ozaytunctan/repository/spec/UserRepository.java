package com.ozaytunctan.repository.spec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozaytunctan.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
