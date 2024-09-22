package com.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.model.Matching;
import com.hackathon.repository.MatchingRepository;

@Service
public class MatchingService_2 {

    @Autowired
    private MatchingRepository matchingRepository;

    public Matching saveMatching(Matching matching) {
        return matchingRepository.save(matching);
    }

    
}
