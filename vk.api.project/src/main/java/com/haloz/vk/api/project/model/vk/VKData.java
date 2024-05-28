package com.haloz.vk.api.project.model.vk;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VKData {
    private String type;
    private String event_id;
    private String v;
    private VKObjectData object;
    private Long group_id;
}
