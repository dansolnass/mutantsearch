
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutant.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.WebApplicationContext;




@SpringBootApplication(scanBasePackages = {"com.mutant.controller","com.mutant.dto", "com.mutant.health","com.mutant.main", "com.mutant.model", "com.mutant.service", "com.mutant.repository","com.mutant.model" })
@EnableJpaRepositories("com.mutant.*")
@ComponentScan(basePackages = { "com.mutant.*" })
@EntityScan("com.mutant.*") 
public class MutantBootMain {


    static final Logger LOGGER = LoggerFactory.getLogger(MutantBootMain.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MutantBootMain.class);
        app.run(args);
    }


}
