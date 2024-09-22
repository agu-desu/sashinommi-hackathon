package com.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
}
