package com.hackathon.controllers.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hackathon.models.Matching;
import com.hackathon.service.MatchingService;

@Controller
public class MatchingController {

    @Autowired
    private MatchingService matchingService;

    @PostMapping("/chat")
    public String submitForm(@ModelAttribute Matching matching) {
        matchingService.saveMatching(matching);
        return "nextpage/index";
    }
}
