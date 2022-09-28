package com.taskManager.taskmanager.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="task")
@Data @NoArgsConstructor @AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(name = "description")
    private String description;
    @Column(name = "done")
    private Boolean done;
    @Column(name = "due_date")
    private LocalDate dueDate;
}
