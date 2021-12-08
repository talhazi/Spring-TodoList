package com.Spring.TodoList.controller;

import com.Spring.TodoList.entity.Person;
import com.Spring.TodoList.entity.Task;
import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonRepository personRepository;
    private TaskRepository taskRepository;

    public PersonController(PersonRepository personRepository, TaskRepository taskRepository) {
        this.personRepository = personRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable String personId){
        return personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @PostMapping("/{personId}/tasks")
    public void addTask(@PathVariable String personId, @RequestBody Task task){
        Person person = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        person.getTodoList().add(task);
    }

    @PostMapping("/tasks/{taskId}")
    public void toggleTaskCompleted(@PathVariable String taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
    }
}
