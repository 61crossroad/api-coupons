package com.naver.financial.demo.user.repository;

import com.naver.financial.demo.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
}
