package com.example.todoApp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application")
public class AppSettings {
    private String uiUrl;

    public String getUiUrl() {
        return uiUrl;
    }

    public void setUiUrl(String uiUrl) {
        this.uiUrl = uiUrl;
    }
}
