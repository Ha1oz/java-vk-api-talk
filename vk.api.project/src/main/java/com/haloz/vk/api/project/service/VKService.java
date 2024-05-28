package com.haloz.vk.api.project.service;

import com.haloz.vk.api.project.model.vk.VKData;
import com.haloz.vk.api.project.service.handler.api.ChainHandler;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VKService {
    private static final Logger LOG = LoggerFactory.getLogger(VKService.class);
    private List<ChainHandler> requestHandlers;

    public String parseData(VKData vkData) {
        LOG.info(vkData.getType() + " : event_id" + vkData.getEvent_id());
        for (ChainHandler h : requestHandlers) {
            if (h.check(vkData.getType())) {
                return h.handle(vkData);
            }
        }
        return vkData.getEvent_id();
    }
}
