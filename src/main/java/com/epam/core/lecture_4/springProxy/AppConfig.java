package com.epam.core.lecture_4.springProxy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("com.epam.core.lecture_4.springProxy")
@Configuration
@EnableTransactionManagement
public class AppConfig {

}
