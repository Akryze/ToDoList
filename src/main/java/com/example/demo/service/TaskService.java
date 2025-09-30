package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    public Task addTask(Task task) {
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    public Task setCompleted(Long id, boolean completed) {
        Optional<Task> taskList = taskRepository.findById(id);
        if (taskList.isPresent()) {
            Task task = taskList.get();
            task.setCompleted(completed);
            return taskRepository.save(task);
        }
            return null;
    }

    public void deleteTask (Long id) {
        Optional<Task> taskList = taskRepository.findById(id);
        if(taskList.isPresent()) {
            Task task = taskList.get();
             taskRepository.delete(task);
        }
    }


}
