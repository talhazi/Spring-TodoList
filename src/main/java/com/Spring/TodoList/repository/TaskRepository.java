package com.Spring.TodoList.repository;

import com.Spring.TodoList.entity.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Marker interface for handling the {@link TaskDetails} entity's data
 */
public interface TaskRepository extends JpaRepository<TaskDetails,String> {
}
