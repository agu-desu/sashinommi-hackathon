package com.hackathon.form;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChatForm {
    
    /** ユーザー名 */
    private String name;

    /**  内容　*/
    private String message;

    /**  送信時間*/
    private LocalDateTime sendTime;

}