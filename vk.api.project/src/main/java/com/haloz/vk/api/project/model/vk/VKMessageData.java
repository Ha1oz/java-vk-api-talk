package com.haloz.vk.api.project.model.vk;

import com.google.gson.Gson;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VKMessageData {
    private Long date;
    private Long from_id;
    private Long id;
    private String text;
    private Long random_id;
}
