package com.jp.configclient.controller;

import com.jp.configclient.config.Config;
import com.jp.configclient.service.CustomLogService;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    /**
     * aquí injectamos el bean
     */
//    @Autowired
//    private MeterRegistry meterRegistry;
    private final Config config;

    @Value("${server.port}")
    private String serverPort;

    public AppController(Config config) {
        this.config = config;
    }

    @GetMapping
    @Timed("com.jp.client.get.app.name")
    @Operation(summary = "Get name of app and port name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "When the response Ok",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = String.class)))}),
            @ApiResponse(responseCode = "400", description = "The response was not found"),
    })
    public ResponseEntity<String> getAppName() {
        // esto sirve para crear una nueva métrica personalizada, esta métrica
        // solo aparecerá una vez se llame este método
//        meterRegistry.counter("jp.com.configclient.name").increment();
//        ahora lo que hago aquí es que la métrica tenga un tag, segun el valor
//        int value = new Random().nextInt();
//        meterRegistry.counter("jp.com.configclient.metric.name", "level",
//                (value < 3 ? "jr" : "sr")).increment(value);
        customLogService.printLog();
        return ResponseEntity.ok(config.getApplicationName() + "My port is: " + serverPort);
    }
}
