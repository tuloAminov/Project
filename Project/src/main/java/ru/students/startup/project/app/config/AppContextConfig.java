package ru.students.startup.project.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.students.startup.project.app.services.IdProvider;

@Configuration
@ComponentScan(basePackages = "ru.students.startup.project.app")
public class AppContextConfig {

    @Bean
    public IdProvider idProvider(){
        return new IdProvider();
    }
}
