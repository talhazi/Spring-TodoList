package com.Spring.TodoList.controller;

import com.Spring.TodoList.entity.PersonDetails;
import com.Spring.TodoList.entity.TaskDetails;
import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
import com.Spring.TodoList.request.TaskData;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

/**
 * Responsible for accessing the data layer of the Task Entity and modify it according to the appropriate http request
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private PersonRepository personRepository;
    private TaskRepository taskRepository;

    /**
     * Constructor for the TaskController class
     *
     * @param personRepository not null
     * @param taskRepository not null
     */
    public TaskController(PersonRepository personRepository, TaskRepository taskRepository) {
        this.personRepository = personRepository;
        this.taskRepository = taskRepository;
    }

    /**
     * Get request for a specific Task in the table matched by the primary key id
     * Throws exception if there is no Task with the same id in the table
     *
     * @return a {@link TaskDetails} object with the appropriate id
     */
    @GetMapping("/{Id}")
    public TaskDetails getTaskById(@PathVariable String Id){
        return taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * Patch request for a specific Table in the table matched by the primary key id, the required data to be updated
     * is given in the body of the request and mapped to the a {@link TaskData} object
     * Throws exception if there is no Task with the same id in the table
     *
     * @param Id of the {@link TaskDetails} in the repository,  not null
     * @param taskRequest the body of the request is mapped to curtain fields in the {@code TaskData} object, not null
     */
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

    /**
     * Delete request for a specific Task in the table matched by the primary key id
     * Throws exception if there is no Task with the same id in the table
     *
     * @param Id of the {@link TaskDetails} in the repository,  not null
     */
    @DeleteMapping("{Id}")
    public void deleteTask(@PathVariable String Id){
        TaskDetails task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        PersonDetails person = personRepository.findById(task.getOwnerId()).orElseThrow(NoSuchElementException::new);
        person.removeTask(task);
        taskRepository.delete(task);
    }

    /**
     * Get request for the status field of a Task in the table, matched by the primary key id
     * Throws exception if there is no Task with the same id in the table
     *
     * @param Id of the {@link TaskDetails} in the repository,  not null
     * @return the status field of a {@code TaskDetails} object, not null
     */
    @GetMapping("/{Id}/status")
    public TaskDetails.Status getTaskStatusById(@PathVariable String Id){
        TaskDetails task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        return task.getStatus();
    }

    /**
     * Put request for the status field of a Task in the table, matched by the primary key id, and thus updating it
     * Throws exception if there is no Task with the same id in the table
     *
     * @param Id of the {@link TaskDetails} in the repository,  not null
     * @param newStatus given in the body of the request, not null
     */
    @PutMapping("/{Id}/status")
    public void setTaskStatusById(@PathVariable String Id, @RequestBody TaskDetails.Status newStatus){
        TaskDetails task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        task.setStatus(newStatus);
        taskRepository.save(task);
    }

    /**
     * Get request for the owner field of a Task in the table, matched by the primary key id
     * Throws exception if there is no Task with the same id in the table
     *
     * @param Id of the {@link TaskDetails} in the repository,  not null
     * @return the ownerId field of a {@code TaskDetails} object, not null
     */
    @GetMapping("/{Id}/owner")
    public String getTaskOwnerById(@PathVariable String Id){
        TaskDetails task = taskRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        return task.getOwnerId();
    }

    /**
     * Put request for the owner field of a Task in the table, matched by the primary key id, and thus updating it
     * Throws exception if there is no Task with the same id in the table
     *
     * @param Id of the {@link TaskDetails} in the repository,  not null
     * @param newOwner given in the body of the request, not null
     */
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
