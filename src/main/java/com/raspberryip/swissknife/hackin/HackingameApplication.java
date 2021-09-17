package com.raspberryip.swissknife.hackin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.Bootstrap;

import java.io.IOException;


@Configuration
@ComponentScan
public class HackingameApplication extends Bootstrap {
	private static final Logger logger = LoggerFactory.getLogger(HackingameApplication.class);

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx = SpringApplication.run(HackingameApplication.class, args);
		Bootstrap.main(args);
		SpringApplication.exit(ctx);
	}

}
