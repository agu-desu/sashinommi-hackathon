package com.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hackathon.form.ChatForm;
import com.hackathon.model.Matching;
import com.hackathon.service.MatchingService;
import com.hackathon.service.MatchingService_2;

@Controller
public class MatchingController {

    @Autowired
    private MatchingService matchingService;

    @Autowired
    private MatchingService_2 matchingService_2;

    @GetMapping(value = "/demo")
    public String index(Model model, @RequestParam("matchingId") Long matchingId, @RequestParam("name") String name) {
        String url = matchingService.matching(matchingId);
        model.addAttribute("url", url);
        model.addAttribute("chatName", name);
        model.addAttribute("chatForm", new ChatForm());
        model.addAttribute("matchingId", matchingId);
        return "chat/index";
    }

    @PostMapping("/chat")
    public String submitForm(@ModelAttribute Matching matching, RedirectAttributes redirectAttributes) {
        Matching savedMatching = matchingService_2.saveMatching(matching);
        redirectAttributes.addAttribute("matchingId", savedMatching.getMatchId());
        redirectAttributes.addAttribute("name", savedMatching.getMatchName());
        return "redirect:/demo";
    }
}
