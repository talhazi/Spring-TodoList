package com.Spring.TodoList;

import com.Spring.TodoList.repository.PersonRepository;
import com.Spring.TodoList.repository.TaskRepository;
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

	@Override
	public void run(String... args){

	}
}
