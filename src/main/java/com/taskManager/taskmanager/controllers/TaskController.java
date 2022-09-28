package com.taskManager.taskmanager.controllers;

import com.taskManager.taskmanager.entities.Task;
import com.taskManager.taskmanager.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskServices taskServices;

    @GetMapping("/tasks")
    public String tasks(Model model ){
        List<Task> tasks =  taskServices.getTaskList();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PatchMapping("/tasks/{id}")
    public  String updateTask(@PathVariable("id") Long id){
        taskServices.markTaskFinish(id);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/new")
    public String index(Model model){
        model.addAttribute("tasks",new Task());
        return "new-task";
    }

    @DeleteMapping("/tasks/{id}")
    public  String deleteTask(@PathVariable("id") Long id){
        taskServices.deleteTask(id);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks")
    public  String CreateTask(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Task task, Model model){
        model.addAttribute(task);
        task.setDone(false);
        taskServices.createTask(task);
        return "redirect:/tasks";
    }
}
