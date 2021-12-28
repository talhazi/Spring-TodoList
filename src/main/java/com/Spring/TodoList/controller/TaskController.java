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

    @GetMapping("/{Id}")
    public Task getTaskById(@PathVariable String Id){
        return taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
    }

    @PatchMapping("/{Id}")
    public void updateTaskById(@PathVariable String Id, @RequestBody(required = false) AddTaskRequest taskRequest){
        Task task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        if(taskRequest.getDetails() != null)
            task.setDetails(taskRequest.getDetails());
        if(taskRequest.getDueDate() != null)
            task.setDueDate(taskRequest.getDueDate());
        taskRepository.save(task);
    }

    @DeleteMapping("{Id}")
    public void deleteTask(@PathVariable String Id){
        Task task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        Person person = personRepository.findById(task.getOwnerId()).orElseThrow(NoSuchElementException::new);
        person.removeTask(task);
        taskRepository.delete(task);
    }

    @GetMapping("/{Id}/status")
    public boolean getTaskStatusById(@PathVariable String Id){
        Task task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        return task.getStatus();
    }

    @PutMapping("/{Id}/status")
    public void setTaskStatusById(@PathVariable String Id, boolean newStatus){
        Task task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        task.setStatus(newStatus);
    }

    @GetMapping("/{Id}/owner")
    public String getTaskOwnerById(@PathVariable String Id){
        Task task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        return task.getOwnerId();
    }

    @PutMapping("/{Id}/owner")
    public void setTaskOwnerById(@PathVariable String Id, String newOwner){
        Task task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        task.setOwnerId(newOwner);
    }

}
