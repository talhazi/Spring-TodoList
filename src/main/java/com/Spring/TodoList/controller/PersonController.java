package com.Spring.TodoList.controller;

import com.Spring.TodoList.entity.Person;
import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
