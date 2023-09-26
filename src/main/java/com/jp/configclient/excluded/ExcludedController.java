package com.jp.configclient.excluded;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excluded-controller")
public class ExcludedController {

    public ResponseEntity<String> getSomeString() {
        return ResponseEntity.ok( "My info is excluded");
    }
}
