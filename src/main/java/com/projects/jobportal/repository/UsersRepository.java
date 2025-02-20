package com.projects.jobportal.repository;

import com.projects.jobportal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
