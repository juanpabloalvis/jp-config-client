package com.jp.configclient.controller;

import com.jp.configclient.config.Config;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application-name")
public class AppController {

    private final Config config;

    public AppController(Config config) {
        this.config = config;
    }

    @GetMapping
    public ResponseEntity<String> getAppName() {
        return ResponseEntity.ok(config.getApplicationName());
    }
}
