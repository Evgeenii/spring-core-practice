package org.example.config;

import org.example.beans.employee.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class Config {

    @Bean
    public Employee mishka() {
        return new Employee("Mishka");
    }

    @Bean
    public Employee zelya() {
        return new Employee("Zelya");
    }
}
