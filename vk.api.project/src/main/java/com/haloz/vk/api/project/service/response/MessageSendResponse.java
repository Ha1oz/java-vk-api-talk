package com.haloz.vk.api.project.service.response;

import com.haloz.vk.api.project.model.response.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageSendResponse {
    private static final Logger LOG = LoggerFactory.getLogger(MessageSendResponse.class);

    @Value("${vk.auth.token}")
    private String authToken;
    private final String url = "https://api.vk.com/method/messages.send";
    public void sendToVK(MessageDto model) {
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();

        params.add("access_token", authToken);
        params.add("user_id", model.getUserId().toString());
        params.add("message", model.getText());
        params.add("random_id", model.getRandomId().toString());
        params.add("v", model.getVersion());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();

        LOG.info("Response with answer sent to user : " + model.getUserId());

        restTemplate.postForEntity(url, request, String.class );
    }
}
