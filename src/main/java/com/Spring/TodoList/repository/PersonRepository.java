package com.Spring.TodoList.repository;

import com.Spring.TodoList.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {
}
