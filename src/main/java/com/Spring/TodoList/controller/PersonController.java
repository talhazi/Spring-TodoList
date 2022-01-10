package com.Spring.TodoList.controller;

import com.Spring.TodoList.entity.PersonDetails;
import com.Spring.TodoList.entity.TaskDetails;
import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
import com.Spring.TodoList.request.PersonData;
import com.Spring.TodoList.request.TaskData;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Responsible for accessing the data layer of the Person Entity and modify it according to the appropriate http request
 */
@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonRepository personRepository;
    private TaskRepository taskRepository;
    private SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Constructor for the PersonController class
     *
     * @param personRepository not null
     * @param taskRepository not null
     */
    public PersonController(PersonRepository personRepository, TaskRepository taskRepository) {
        this.personRepository = personRepository;
        this.taskRepository = taskRepository;
    }

    /**
     * Adds a person to the Person Table through a post request
     *
     * @param personRequest the body of the request is mapped to a {@link PersonData} object, not null
     * @return the {@link PersonDetails} object created, not null
     */
    @PostMapping
    public PersonDetails addPerson(@RequestBody PersonData personRequest){
        PersonDetails person = new PersonDetails();
        person.setName(personRequest.getName());
        person.setEmail(personRequest.getEmail());
        person.setFavoriteProgrammingLanguage(personRequest.getFavoriteProgrammingLanguage());
        return personRepository.save(person);
    }

    /**
     * Get request for all the rows in the Person Table
     *
     * @return a list of all the {@link PersonDetails} in the repository, may be null
     */
    @GetMapping
    public List<PersonDetails> getAllPeople(){
        return personRepository.findAll();
    }

    /**
     * Get request for a specific Person in the table matched by the primary key id
     * Throws exception if there is no Person with the same id in the table
     *
     * @return a {@link PersonDetails} object with the appropriate id
     */
    @GetMapping("/{Id}")
    public PersonDetails getPersonById(@PathVariable String Id){
        return personRepository.findById(Id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * Patch request for a specific Person in the table matched by the primary key id, the required data to be updated
     * is given in the body of the request and mapped to the a {@link PersonData} object
     * Throws exception if there is no Person with the same id in the table
     *
     * @param Id of the {@link PersonDetails} in the repository,  not null
     * @param personRequest the body of the request is mapped to curtain fields in the {@code PersonData} object, not null
     */
    @PatchMapping("/{Id}")
    public void updatePersonById(@PathVariable String Id, @RequestBody(required = false) PersonData personRequest){
        PersonDetails person = personRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        if(personRequest.getName() != null)
            person.setName(personRequest.getName());
        if(personRequest.getEmail() != null)
            person.setEmail(personRequest.getEmail());
        if(personRequest.getFavoriteProgrammingLanguage() != null)
            person.setFavoriteProgrammingLanguage(personRequest.getFavoriteProgrammingLanguage());
        personRepository.save(person);
    }

    /**
     * Delete request for a specific Person in the table matched by the primary key id
     * Throws exception if there is no Person with the same id in the table
     *
     * @param Id of the {@link PersonDetails} in the repository,  not null
     */
    @DeleteMapping("/{Id}")
    public void deletePerson(@PathVariable String Id){
        PersonDetails person = personRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        personRepository.delete(person);
    }

    /**
     * Get request for all the tasks a Person currently holds, the person is matched by the primary key id in the table
     * Throws exception if there is no Person with the same id in the table
     *
     * @param Id of the {@link PersonDetails} in the repository,  not null
     * @return the todoList field of the {@code PersonDetails} object, may be null
     */
    @GetMapping("/{Id}/tasks")
    public List<TaskDetails> getAllTasks(@PathVariable String Id){
        PersonDetails person = personRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        return person.getTodoList();
    }

    /**
     * Post request for a new Task, the Task will be added to the Task Table and to a Person that will be its owner,
     * the Person will be matched in the table with the primary key id
     * Throws exception if there is no Person with the same id in the table
     *
     * @param Id of the {@link PersonDetails} in the repository,  not null
     * @param taskRequest the body of the request is mapped to a {@link TaskData} object, not null
     */
    @PostMapping("/{Id}/tasks")
    public void addTask(@PathVariable String Id, @RequestBody TaskData taskRequest) {
        PersonDetails person = personRepository.findById(Id).orElseThrow(NoSuchElementException::new);
        TaskDetails task = new TaskDetails();
        task.setDetails(taskRequest.getDetails());
        task.setDueDate(taskRequest.getDueDate());
        task.setStatus(taskRequest.getStatus());
        task.setTitle(taskRequest.getTitle());
        person.addTask(task);
        taskRepository.save(task);
        personRepository.save(person);
    }
}
