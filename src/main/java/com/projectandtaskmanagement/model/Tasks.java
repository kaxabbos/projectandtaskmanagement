package com.projectandtaskmanagement.model;

import com.projectandtaskmanagement.model.enums.Category;
import com.projectandtaskmanagement.model.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tasks {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String date;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    private Projects project;
    @ManyToOne(fetch = FetchType.LAZY)
    private Users employee;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TaskDescription description;

    public Tasks(String name, String date, Category category, Projects project, Users employee) {
        this.name = name;
        this.date = date;
        this.category = category;
        this.status = Status.WAITING;
        this.project = project;
        this.employee = employee;
        this.description = new TaskDescription("");
    }
}
