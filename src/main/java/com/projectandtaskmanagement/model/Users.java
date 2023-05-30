package com.projectandtaskmanagement.model;

import com.projectandtaskmanagement.model.enums.Role;
import com.projectandtaskmanagement.model.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users implements UserDetails {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String username;
    private String password;
    private String fio;
    private String avatar;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Tasks> tasks;

    public Users(String username, String password, String fio, Role role, String avatar) {
        this.role = role;
        this.username = username;
        this.password = passwordEncoder().encode(password);
        this.fio = fio;
        this.avatar = avatar;
        tasks = new ArrayList<>();
    }

    public int countWaiting() {
        return tasks.stream().filter(task -> task.getStatus() == Status.WAITING).toList().size();
    }

    public int countInProgress() {
        return tasks.stream().filter(task -> task.getStatus() == Status.IN_PROGRESS).toList().size();
    }

    public int countFinish() {
        return tasks.stream().filter(task -> task.getStatus() == Status.FINISH).toList().size();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
