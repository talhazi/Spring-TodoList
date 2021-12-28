package com.Spring.TodoList.controller;

import com.Spring.TodoList.entity.Person;
import com.Spring.TodoList.entity.Task;
import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
import com.Spring.TodoList.request.AddPersonRequest;
import com.Spring.TodoList.request.AddTaskRequest;
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

    @GetMapping("/{Id}")
    public Person getPersonById(@PathVariable String Id){
        return personRepository.findById(Id).orElseThrow(NoSuchElementException::new);
    }


    @PatchMapping("/{Id}")
    public void updatePersonById(@PathVariable String Id, @RequestBody(required = false) AddPersonRequest personRequest){
        Person person = personRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        if(personRequest.getName() != null)
            person.setName(personRequest.getName());
        if(personRequest.getEmail() != null)
            person.setEmail(personRequest.getEmail());
        if(personRequest.getFavoriteProgrammingLanguage() != null)
            person.setFavoriteProgrammingLanguage(personRequest.getFavoriteProgrammingLanguage());
        personRepository.save(person);
    }

    @DeleteMapping("/{Id}")
    public void deletePerson(@PathVariable String Id){
        Person person = personRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        personRepository.delete(person);
    }

    @GetMapping("/{Id}/tasks")
    public List<Task> getAllTasks(@PathVariable String Id){
        Person person = personRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        return person.getTodoList();
    }

    @PostMapping("/{Id}/tasks")
    public void addTask(@PathVariable String Id, @RequestBody AddTaskRequest taskRequest){
        Person person = personRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        Task task = new Task();
        task.setDetails(taskRequest.getDetails());
        task.setDueDate(taskRequest.getDueDate());
        task.setStatus(taskRequest.getStatus());
        task.setTitle(taskRequest.getTitle());
        person.addTask(task);
        taskRepository.save(task);
        personRepository.save(person);
    }

}
