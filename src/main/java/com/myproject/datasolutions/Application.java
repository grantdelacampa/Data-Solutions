package com.myproject.datasolutions;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.*;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {

  /*To build as WAR uncomment this */
	/*
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }

*/
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}