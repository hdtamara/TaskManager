package com.taskManager.taskmanager.services;

import com.taskManager.taskmanager.entities.Task;
import com.taskManager.taskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {
    @Autowired
    private TaskRepository repository;

    public List<Task> getTaskList(){
        return repository.findAll();
    }

    public Task createTask(Task task){
        return  repository.save(task);
    }

    public  Boolean markTaskFinish(Long id){
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()) {
            task.get().setDone(true);
            repository.save(task.get());
            return true;
        }
        return false;
    }

    public Boolean deleteTask(Long id){
        repository.deleteById(id);
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()) {
            return false;
        }
        return true;
    }
}
