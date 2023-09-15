package com.jp.configclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@RefreshScope
// in order to update against configurations files and configuration server
// it is necessary to include the actuator config, it will enable an actuator endpoint that need to be called
// in this case is:
// http://localhost:8082/actuator/refresh
public class Config {
    @Value("${application.name}")
    private String applicationName;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
