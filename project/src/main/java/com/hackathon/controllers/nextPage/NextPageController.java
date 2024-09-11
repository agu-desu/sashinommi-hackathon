package com.hackathon.controllers.nextPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hackathon.services.MatchingService;

@Controller
public class NextPageController {

    @Autowired
    private MatchingService matchingService;

    @GetMapping(value = "/demo")
    public String index(Model model, @RequestParam("matchingId") Long matchingId) {
        String url = matchingService.matching(matchingId);
        model.addAttribute(
                "url", url);
        return "nextpage/index";
    }
}
