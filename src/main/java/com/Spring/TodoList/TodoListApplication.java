package com.Spring.TodoList;

import com.Spring.TodoList.entity.PersonDetails;
import com.Spring.TodoList.entity.TaskDetails;
import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The class that runs the whole todoList application
 */
@SpringBootApplication
public class TodoListApplication implements CommandLineRunner {

	private PersonRepository personRepository;

	private TaskRepository taskRepository;


	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	@Override // where is the exception thrown?
	public void run(String... args){

//		for (int i = 0; i < 100; i++) {
//			int finalI = i;
//			new Thread(() -> {
//				String name = String.format("Name%d", finalI);
//				String email = String.format("Email%d@gmail.com", finalI);
//				String fav = String.format("Java%d", finalI);
//				PersonDetails p = new PersonDetails(name, email, fav);
//
//				String date = "2022-01-05";
//				String details = String.format("Details%d", finalI);
//				TaskDetails.Status status = TaskDetails.Status.active;
//				TaskDetails t = new TaskDetails(name, status, details, date);
//
//				personRepository.save(p);
//				taskRepository.save(t);
//			}).start();
//		}
	}
}
