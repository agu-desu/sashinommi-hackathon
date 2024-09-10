package com.hackathon.services;

import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.Form.ChatForm;
import com.hackathon.models.Chat;
import com.hackathon.repositories.ChatRepository;

@Service
public class ChatService {
    @Autowired
    ChatRepository chatRepository;

    /** 
     * 上位30件のチャットを取得します。
     * @return chatForms すべてのチャット
    */
    public List<ChatForm> getChat () {
        List<Chat> chats = new ArrayList<>();
        chats = chatRepository.findAll();

        if(chats.isEmpty()) return new ArrayList<>();

        List<ChatForm> chatForms = chats.stream().sorted(Comparator.comparing(Chat::getChatId).reversed())
        .limit(30).map(chat -> {
            ChatForm form = new ChatForm();
            form.setName(chat.getChatName());
            form.setMessage(chat.getChatMessage());
            form.setSendTime(chat.getChatTime());
            return form;
        })
        .collect(Collectors.toList());
        return chatForms;
    }
}
