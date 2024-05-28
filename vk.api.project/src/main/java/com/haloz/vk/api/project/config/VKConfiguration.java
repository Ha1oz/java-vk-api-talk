package com.haloz.vk.api.project.config;

import com.haloz.vk.api.project.service.handler.ConfirmHandler;
import com.haloz.vk.api.project.service.handler.MessageHandler;
import com.haloz.vk.api.project.service.handler.api.ChainHandler;
import com.haloz.vk.api.project.service.response.MessageSendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VKConfiguration {
    @Value("${vk.confirm.response.string}")
    private String confirmResponseString;

    @Autowired
    private MessageSendResponse messageSendResponse;

    @Bean
    public List<ChainHandler> requestHandlers() {
        return List.of(
                new MessageHandler(messageSendResponse, "message_new"),
                new ConfirmHandler("confirmation", confirmResponseString)
        );
    }
}
