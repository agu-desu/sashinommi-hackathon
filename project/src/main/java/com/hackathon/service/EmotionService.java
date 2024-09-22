package com.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.model.Emotion;
import com.hackathon.repository.EmotionRepository;

@Service
public class EmotionService {
    
    @Autowired EmotionRepository emotionRepository;

    public List<Emotion> getEmotionList() {
        return emotionRepository.findAll();
    }
}
