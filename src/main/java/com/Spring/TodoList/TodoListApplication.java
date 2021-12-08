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

		Person person2 = new Person();
		person2.setId("2");
		person2.setName("Dan Amsalem");
		person2.setEmail("danams@post.bgu.ac.il");
		person2.setFavoriteProgrammingLanguage("Ocaml");

		Person person3 = new Person();
		person3.setId("4");
		person3.setName("Noy Shani");
		person3.setEmail("hazit@post.bgu.ac.il");
		person3.setFavoriteProgrammingLanguage("Java");

		Task task1 = new Task();
		task1.setId("1");
		task1.setDetails("homework");
		task1.setDueDate(new GregorianCalendar(2021, Calendar.DECEMBER, 1).getTime());
		task1.setOwnerId("1");

		Task task2 = new Task();
		task2.setId("2");
		task2.setDetails("project");
		task2.setDueDate(new GregorianCalendar(2021, Calendar.DECEMBER, 5).getTime());
		task2.setOwnerId("4");

		Task task3 = new Task();
		task3.setId("10");
		task3.setDetails("project");
		task3.setDueDate(new GregorianCalendar(2021, Calendar.DECEMBER, 5).getTime());
		task3.setOwnerId("1");

		Task task4 = new Task();
		task4.setId("3");
		task4.setDetails("blabla3");
		task4.setDueDate(new GregorianCalendar(2021, Calendar.DECEMBER, 5).getTime());
		task4.setOwnerId("2");



		person.getTodoList().add(task1);
		person.getTodoList().add(task3);
		person2.getTodoList().add(task4);
		person3.getTodoList().add(task2);


		taskRepository.save(task1);
		taskRepository.save(task2);
		taskRepository.save(task3);
		taskRepository.save(task4);

		personRepository.save(person);
		personRepository.save(person2);
		personRepository.save(person3);


	}
}
