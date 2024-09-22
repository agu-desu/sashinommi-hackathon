package com.hackathon.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.service.MatchingService;

@RestController
public class DeleteMatchApiController {
    @Autowired
    private MatchingService matchingService;
    @PostMapping("/api/deleteMatch")
    public String deleteMatch(@RequestParam("matchingId") Long matchingId) {
        matchingService.deleteMatch(matchingId);
        return "";
    }
}
