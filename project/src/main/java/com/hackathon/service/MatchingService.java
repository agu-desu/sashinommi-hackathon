package com.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.model.Matching;
import com.hackathon.repository.MatchingRepository;

@Service
public class MatchingService {

    @Autowired
    private MatchingRepository matchingRepository;

    public String matching(Long matchingId) {
        try {
            Matching matching = matchingRepository.getReferenceById(matchingId);
            List<Matching> allMatching = matchingRepository.findAll();

            long emotionId = matching.getMatchemotionId();

            for (Matching m : allMatching) {
                if (matchingId == m.getMatchId()) {
                    continue;
                }

                if (emotionId == m.getMatchemotionId()) {
                    String url = matched(matching, m);
                    return url;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    private String matched(Matching yourself, Matching opp) {
        String url;
        url = opp.getMatchUrl();
        try{
            matchingRepository.deleteById(yourself.getMatchId());
            matchingRepository.deleteById(opp.getMatchId());
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return url;
    }

    public void deleteMatch(long matchingId) {
        try{
            matchingRepository.deleteById(matchingId);
        }
        catch(Exception e) {
            e.printStackTrace();
            return;
        }
        return;
    }
}
