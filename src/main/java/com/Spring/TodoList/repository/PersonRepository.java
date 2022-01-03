package com.Spring.TodoList.repository;

import com.Spring.TodoList.entity.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonDetails,String> {
}
