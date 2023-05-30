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
public class TaskDescription {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 5000)
    private String description;

    public TaskDescription(String description) {
        this.description = description;
    }
}
