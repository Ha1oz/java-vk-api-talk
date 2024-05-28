package com.haloz.vk.api.project.service.handler;

import com.haloz.vk.api.project.model.response.MessageDto;
import com.haloz.vk.api.project.model.vk.VKData;
import com.haloz.vk.api.project.service.handler.api.ChainHandler;
import com.haloz.vk.api.project.service.response.MessageSendResponse;

public class MessageHandler extends ChainHandler {
    private final String resultMessage = "ok";
    private final String answer = "Вы сказали: ";
    private final MessageSendResponse responseService;

    public MessageHandler(MessageSendResponse service, String typeForCheck) {
        super(typeForCheck);
        responseService = service;
    }
    @Override
    public String handle(VKData vkData) {
        String userText = vkData.getObject().getMessage().getText();
        String version = vkData.getV();
        Long userId = vkData.getObject().getMessage().getFrom_id();
        Long randomId = vkData.getObject().getMessage().getRandom_id();

        MessageDto messageSendModel = new MessageDto();

        messageSendModel.setText(answer + userText);
        messageSendModel.setUserId(userId);
        messageSendModel.setRandomId(randomId);
        messageSendModel.setVersion(version);

        responseService.sendToVK(messageSendModel);

        return resultMessage;
    }
}
