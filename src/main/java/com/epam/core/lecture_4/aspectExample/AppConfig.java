package com.epam.core.lecture_4.aspectExample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.epam.core.lecture_4.aspectExample")
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

}
