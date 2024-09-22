package com.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hackathon.form.UserEmotionForm;
import com.hackathon.model.Matching;
import com.hackathon.service.EmotionService;

@Controller
public class TopController {
    @Autowired EmotionService emotionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("userEmotionForm", new UserEmotionForm());
        model.addAttribute("emotionList", emotionService.getEmotionList());
        return "user/index";
    }
}
