package com.dumbdodo.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.dumbdodo.*")
@EntityScan("com.dumbdodo.member.entity")
@EnableJpaRepositories("com.dumbdodo.member.repository")
@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class
})
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}
