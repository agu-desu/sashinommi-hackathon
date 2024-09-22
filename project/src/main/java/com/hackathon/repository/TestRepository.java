package com.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.model.Todo;

@Repository
public interface TestRepository extends JpaRepository<Todo, Integer> {
}
