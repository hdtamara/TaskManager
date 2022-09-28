package com.taskManager.taskmanager.repositories;

import com.taskManager.taskmanager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//inyección de JPA para realizar las funciones crud
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}
