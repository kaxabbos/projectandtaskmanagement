package com.projectandtaskmanagement.controller.main;

import com.projectandtaskmanagement.model.Tasks;
import com.projectandtaskmanagement.model.Users;
import com.projectandtaskmanagement.repo.ProjectsRepo;
import com.projectandtaskmanagement.repo.TaskDescriptionRepo;
import com.projectandtaskmanagement.repo.TasksRepo;
import com.projectandtaskmanagement.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    @Autowired
    protected ProjectsRepo projectsRepo;
    @Autowired
    protected UsersRepo usersRepo;
    @Autowired
    protected TasksRepo tasksRepo;
    @Autowired
    protected TaskDescriptionRepo taskDescriptionRepo;
    @Value("${upload.img}")
    protected String uploadImg;

    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    protected String defaultAvatar = "def.jpeg";

    protected Users getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            return usersRepo.findByUsername(userDetail.getUsername());
        }
        return null;
    }

    protected String getRole() {
        Users users = getUser();
        if (users == null) return "NOT";
        return users.getRole().toString();
    }

    protected String DateNow() {
        return LocalDateTime.now().toString().substring(0, 10);
    }
}