package com.haloz.vk.api.project.service.handler.api;

import com.haloz.vk.api.project.model.vk.VKData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ChainHandler {

    protected final String typeForCheck;

    public boolean check(String enterType) {
        return !enterType.isEmpty() && enterType.equals(typeForCheck);
    }
    public abstract String handle(VKData data);
}
