package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.annotation.PostConstruct;

@Configuration
public class MessagesConfig {
    @Autowired
    private ResourceBundleMessageSource messageSource;

    @PostConstruct
    public void addMessageBaseName() {
        messageSource.addBasenames("i18n/messages");
        messageSource.addBasenames("i18n/messages_zh_TW");
    }
}
