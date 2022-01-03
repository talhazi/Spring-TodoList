package com.Spring.TodoList.controller;

import com.Spring.TodoList.entity.PersonDetails;
import com.Spring.TodoList.entity.TaskDetails;
import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
import com.Spring.TodoList.request.TaskData;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

/**
 * Handles all the task requests
 */
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
    public TaskDetails getTaskById(@PathVariable String Id){
        return taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
    }

    @PatchMapping("/{Id}")
    public void updateTaskById(@PathVariable String Id, @RequestBody(required = false) TaskData taskRequest){
        TaskDetails task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        if(taskRequest.getDetails() != null)
            task.setDetails(taskRequest.getDetails());
        if(taskRequest.getDueDate() != null)
            task.setDueDate(taskRequest.getDueDate());
        if(taskRequest.getStatus() != null)
            task.setStatus(taskRequest.getStatus());
            PersonDetails owner = personRepository.findById(task.getOwnerId()).orElseThrow(NoSuchElementException::new);
            if (task.getStatus().equals(TaskDetails.Status.done)) {
                owner.setActiveTaskCount(owner.getActiveTaskCount() - 1);
            }
            else {
                owner.setActiveTaskCount(owner.getActiveTaskCount() + 1);
            }
        if(taskRequest.getTitle() != null)
            task.setTitle(taskRequest.getTitle());
        taskRepository.save(task);
    }

    @DeleteMapping("{Id}")
    public void deleteTask(@PathVariable String Id){
        TaskDetails task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        PersonDetails person = personRepository.findById(task.getOwnerId()).orElseThrow(NoSuchElementException::new);
        person.removeTask(task);
        taskRepository.delete(task);
    }

    @GetMapping("/{Id}/status")
    public TaskDetails.Status getTaskStatusById(@PathVariable String Id){
        TaskDetails task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        return task.getStatus();
    }

    @PutMapping("/{Id}/status")
    public void setTaskStatusById(@PathVariable String Id, @RequestBody TaskDetails.Status newStatus){
        TaskDetails task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        task.setStatus(newStatus);
        taskRepository.save(task);
    }

    @GetMapping("/{Id}/owner")
    public String getTaskOwnerById(@PathVariable String Id){
        TaskDetails task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        return task.getOwnerId();
    }

    @PutMapping("/{Id}/owner")
    public void setTaskOwnerById(@PathVariable String Id, @RequestBody String newOwner){
        TaskDetails task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        PersonDetails oOwner = personRepository.findById(task.getOwnerId()).orElseThrow(NoSuchElementException::new);
        PersonDetails nOwner = personRepository.findById(newOwner).orElseThrow(NoSuchElementException::new);
        nOwner.addTask(task);
        oOwner.removeTask(task);
        task.setOwnerId(newOwner);
        taskRepository.save(task);
    }
}
