package com.Spring.TodoList.repository;

import com.Spring.TodoList.entity.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskDetails,String> {
}
