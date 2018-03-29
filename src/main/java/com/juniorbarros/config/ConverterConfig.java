package com.juniorbarros.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by juniorbarros on 02/09/2017.
 */
@Configuration
public class ConverterConfig implements WebMvcConfigurer {

    // if you want to add formatters, follow the example bellow.
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToUUIDConverter());
    }
}