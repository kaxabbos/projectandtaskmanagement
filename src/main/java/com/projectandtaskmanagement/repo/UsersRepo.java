package com.projectandtaskmanagement.repo;

import com.projectandtaskmanagement.model.Users;
import com.projectandtaskmanagement.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    List<Users> findAllByOrderByRole();

    List<Users> findAllByRole(Role role);

}
