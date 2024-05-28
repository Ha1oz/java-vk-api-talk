package com.haloz.vk.api.project.service.handler;

import com.haloz.vk.api.project.model.vk.VKData;
import com.haloz.vk.api.project.service.handler.api.ChainHandler;

public class ConfirmHandler extends ChainHandler {
    private final String confirmText;

    public ConfirmHandler(String typeForCheck, String confirmText) {
        super(typeForCheck);

        this.confirmText = confirmText;
    }
    @Override
    public String handle(VKData vkData) {
        if (confirmText.isEmpty() || confirmText.isBlank()) {
            throw new RuntimeException("Confirm text is empty");
        }

        return confirmText;

    }
}
