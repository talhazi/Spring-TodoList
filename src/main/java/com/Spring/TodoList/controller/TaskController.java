package com.Spring.TodoList.controller;

import com.Spring.TodoList.entity.Person;
import com.Spring.TodoList.entity.Task;
import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
import com.Spring.TodoList.request.AddPersonRequest;
import com.Spring.TodoList.request.AddTaskRequest;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private PersonRepository personRepository;
    private TaskRepository taskRepository;

    public TaskController(PersonRepository personRepository, TaskRepository taskRepository) {
        this.personRepository = personRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable String taskId){
        return taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
    }

    @PatchMapping("/{taskId}")
    public void updateTaskById(@PathVariable String taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
        //to update details
    }

    @DeleteMapping("{taskId}")
    public void deleteTask(@PathVariable String taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
        String personId = task.getOwnerId();
        Person person = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        person.getTodoList().remove(task);
        taskRepository.delete(task);
    }

    @GetMapping("/{taskId}/status")
    public boolean getTaskStatusById(@PathVariable String taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
        return task.getStatus();
    }

    @PutMapping("/{taskId}/status")
    public void setTaskStatusById(@PathVariable String taskId, boolean newStatus){
        Task task = taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
        task.setStatus(newStatus);
    }

    @GetMapping("/{taskId}/owner")
    public String getTaskOwnerById(@PathVariable String taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
        return task.getOwnerId();
    }

    @PutMapping("/{taskId}/owner")
    public void setTaskOwnerById(@PathVariable String taskId, String newOwner){
        Task task = taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
        task.setOwnerId(newOwner);
    }

}
