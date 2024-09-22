package com.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.model.Matching;

@Repository
public interface MatchingRepository extends JpaRepository<Matching, Long> {
}