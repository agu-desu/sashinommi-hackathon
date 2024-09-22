package com.hackathon.form;

import lombok.Data;

@Data
public class UserEmotionForm {
    
    /** ユーザー名 */
    private String name;

    /** 感情ID */
    private Long emotionId;
}
