package com.hackthon.ebooks.bookingenrollservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookingenrollserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingenrollserviceApplication.class, args);
	}

}
