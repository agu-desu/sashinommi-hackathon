package com.hackathon.controllers.nextPage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.services.ChatService;
import com.hackathon.Form.ChatForm;

@RestController
public class ChatController {

    @Autowired
    ChatService chatService;

    @GetMapping("/api/getChat")
    public List<ChatForm> getMethodName() {
        List<ChatForm> chats = chatService.getChat();
        return chats;
    }

}
