package com.springbootlearning.learningspringboot3;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<UserAccount, Long> {}
