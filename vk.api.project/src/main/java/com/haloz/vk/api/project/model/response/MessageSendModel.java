package com.haloz.vk.api.project.model.response;

import lombok.Data;

@Data
public class MessageSendModel {
    private Long userId;
    private String text;
    private Long randomId;
    private String version;
}
