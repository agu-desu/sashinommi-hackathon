package com.hackathon.controllers.nextPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.hackathon.models.Todo;
import com.hackathon.repositories.TestRepository;

@Controller
public class NextPageController {

    @Autowired
    private TestRepository testRepository;

    @PostMapping(value = "/demo")
    public String index(Model model) {
        Todo todo = new Todo();
        try {
            todo.setTodoid(1);
            todo.setTodoname("test");
            testRepository.save(todo);
        } catch (Exception e) {
            System.out.println(e);
        }
        model.addAttribute(
                "message", "Next page");

        return "nextpage/index";
    }
}
