package com.projectandtaskmanagement.model;

import com.projectandtaskmanagement.model.enums.Category;
import com.projectandtaskmanagement.model.enums.Status;
import com.projectandtaskmanagement.model.enums.Urgency;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Projects {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String date;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Urgency urgency;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tasks> tasks;

    public Projects(String name, String date, Category category, Urgency urgency) {
        this.name = name;
        this.date = date;
        this.category = category;
        this.urgency = urgency;
        status = Status.WAITING;
        tasks = new ArrayList<>();
    }
}
