package com.augenblick.lunchbox.account.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {
		"com.augenblick.lunchbox.account.rest",
		"com.augenblick.lunchbox.account.service",
		"com.augenblick.lunchbox.account.service.client",
		"com.augenblick.lunchbox.account.validator"
		})
@EnableJpaRepositories(
		basePackages = {"com.augenblick.lunchbox.account.data.client"})
@EntityScan("com.augenblick.lunchbox.account.model")
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		 SpringApplication.run(Main.class, args);
	}

	@Bean
    public MessageSource messageSource() {
    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        
    	messageSource.setBasenames("messages/error_messages");
        messageSource.setDefaultEncoding("UTF-8");
        
        return messageSource;
    }

}
