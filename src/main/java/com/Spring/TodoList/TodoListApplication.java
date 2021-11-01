package com.Spring.TodoList;

import com.Spring.TodoList.entity.Person;
import com.Spring.TodoList.entity.Task;
import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SpringBootApplication
public class TodoListApplication implements CommandLineRunner {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private TaskRepository taskRepository;


	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Person person = new Person();
		person.setId("1");
		person.setName("Tal Hazi");
		person.setEmail("hazit@post.bgu.ac.il");
		person.setFavoriteProgrammingLanguage("Java");

		Task task = new Task();
		task.setId("1");
		task.setDetails("homework");
		task.setDueDate(new GregorianCalendar(2021, Calendar.DECEMBER, 1).getTime());

		person.getTodoList().add(task);

		taskRepository.save(task);
		personRepository.save(person);

	}
}
