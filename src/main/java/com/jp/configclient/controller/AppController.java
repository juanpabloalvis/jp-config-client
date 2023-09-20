package com.jp.configclient.controller;

import com.jp.configclient.config.Config;
import com.jp.configclient.service.CustomLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application-name")
public class AppController {

    @Autowired
    private CustomLogService customLogService;
    private final Config config;

    @Value("${server.port}")
    private String serverPort;

    public AppController(Config config) {
        this.config = config;
    }

    @GetMapping
    public ResponseEntity<String> getAppName() {
        customLogService.printLog();
        return ResponseEntity.ok(config.getApplicationName() + "My port is: " + serverPort);
    }
}
