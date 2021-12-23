package com.Spring.TodoList.controller;

import com.Spring.TodoList.entity.Person;
import com.Spring.TodoList.entity.Task;
import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
import com.Spring.TodoList.request.AddPersonRequest;
import com.Spring.TodoList.request.AddTaskRequest;
import com.Spring.TodoList.request.UpdatePersonRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping
    public Person addPerson(@RequestBody AddPersonRequest personRequest){
        Person person = new Person();
        person.setName(personRequest.getName());
        person.setEmail(personRequest.getEmail());
        person.setFavoriteProgrammingLanguage(personRequest.getFavoriteProgrammingLanguage());
        return personRepository.save(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }

    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable String personId){
        return personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
    }


    @PatchMapping("/{personId}")
    public void updatePersonById(@PathVariable String personId, UpdatePersonRequest newDetails){
        // we need to add check that the fields are not null
        Person person = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        person.setEmail(newDetails.getEmail());
        person.setFavoriteProgrammingLanguage(newDetails.getFavoriteProgrammingLanguage());
        person.setName(newDetails.getName());

    }

    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable String personId){
        Person person = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        personRepository.delete(person);
    }

    @GetMapping("/{personId}/tasks")
    public List<Task> getAllTasks(@PathVariable String personId){
        Person person = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        return person.getTodoList();
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

}
