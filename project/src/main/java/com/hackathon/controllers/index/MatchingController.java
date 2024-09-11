package com.hackathon.controllers.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hackathon.models.Matching;
import com.hackathon.services.MatchingService_2;

@Controller
public class MatchingController {

    @Autowired
    private MatchingService_2 matchingService_2;

    @PostMapping("/chat")
    public String submitForm(@ModelAttribute Matching matching) {
        Matching savedMatching = matchingService_2.saveMatching(matching);
        Long matchingId = savedMatching.getMatchId();
        return "redirect:/demo?matchingId=" + matchingId;
    }
}
