package com.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.model.Emotion;

@Repository
public interface EmotionRepository extends JpaRepository<Emotion, Integer>  {
}
