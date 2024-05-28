package com.haloz.vk.api.project.controller;

import com.haloz.vk.api.project.model.vk.VKData;
import com.haloz.vk.api.project.service.VKService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("${controller.request.mapping}")
public class VKController {
    private VKService vkService;

    @PostMapping
    public ResponseEntity<?> connect(@RequestBody VKData requestFromVK) {
        return ResponseEntity.ok(vkService.parseData(requestFromVK));
    }
}
