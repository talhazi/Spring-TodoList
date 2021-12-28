package com.Spring.TodoList;

import com.Spring.TodoList.entity.Person;
import com.Spring.TodoList.entity.Task;
import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


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

//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//		Person person = new Person();
//		person.setName("Tal Hazi");
//		person.setEmail("hazit@post.bgu.ac.il");
//		person.setFavoriteProgrammingLanguage("Java");


//		Task task1 = new Task();
//		task1.setDetails("homework");
//
//		task1.setDueDate(dateFormat.format(Calendar.getInstance().getTime()));
//		task1.setOwnerId("1");

//			person.getTodoList().add(task1);
//		person.addTask(task1);

//		taskRepository.save(task1);
//		personRepository.save(person);



	}
}
