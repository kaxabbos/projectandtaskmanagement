package com.projectandtaskmanagement.repo;

import com.projectandtaskmanagement.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectsRepo extends JpaRepository<Projects, Long> {
    List<Projects> findAllByOrderByIdDesc();
}
