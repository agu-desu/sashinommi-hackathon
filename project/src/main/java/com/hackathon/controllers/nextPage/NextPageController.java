package com.hackathon.controllers.nextPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import com.hackathon.services.MatchingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NextPageController {

    @Autowired
    private MatchingService matchingService;

    @PostMapping(value = "/demo")
    public String index(Model model) {
        int matchingId = 22 ; 
        String url = matchingService.matching();
        model.addAttribute(
                "url", url);
        model.addAttribute("mathingId", matchingId);
        return "nextpage/index";
    }

    @GetMapping("/api/deleteMatch")
    public void deleteMatch(@RequestParam("matchingId") Long matchingId) {
        matchingService.deleteMatch(matchingId);
        return;
    }
    
}
