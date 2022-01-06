package com.Spring.TodoList.repository;

import com.Spring.TodoList.entity.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Marker interface for handling the {@link PersonDetails} entity's data
 */
public interface PersonRepository extends JpaRepository<PersonDetails,String> {
}
