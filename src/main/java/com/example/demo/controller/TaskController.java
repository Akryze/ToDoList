package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/getAllTasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/create")
    public Task createTask (@RequestBody Task task) {
        return taskService.addTask(task);

    }

    @PutMapping("/{id}")
    public Task setCompleted (@PathVariable Long id, @RequestBody boolean completed) {
        return taskService.setCompleted(id, completed);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask (@PathVariable Long id) {
            taskService.deleteTask(id);
    }




}
