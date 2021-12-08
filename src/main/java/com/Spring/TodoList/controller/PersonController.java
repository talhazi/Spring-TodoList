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
    public Person addPerson(@RequestBody AddPersonRequest personRequest){
        Person person = new Person();
        person.setName(personRequest.getName());
        person.setEmail(personRequest.getEmail());
        person.setFavoriteProgrammingLanguage(personRequest.getFavoriteProgrammingLanguage());
        return personRepository.save(person);
    }

    @PostMapping("/{personId}/tasks")
    public void addTask(@PathVariable String personId, @RequestBody AddTaskRequest taskRequest){
        Person person = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        Task task = new Task();
        task.setDetails(taskRequest.getDetails());
        task.setDueDate(taskRequest.getDueDate());
        person.getTodoList().add(task);
        taskRepository.save(task);
        personRepository.save(person);
    }

    @PostMapping("/tasks/{taskId}")
    public void toggleTaskCompleted(@PathVariable String taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
        task.setStatus(!task.getStatus());
        taskRepository.save(task);
    }

    @DeleteMapping("{personId}/tasks/{taskId}")
    public void deleteTask(@PathVariable String personId, @PathVariable String taskId){
        Person person = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        Task task = taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
        person.getTodoList().remove(task);
        taskRepository.delete(task);
    }

    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable String personId){
        Person person = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        personRepository.delete(person);
    }

}
