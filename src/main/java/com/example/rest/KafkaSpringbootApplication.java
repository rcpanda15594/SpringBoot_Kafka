package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaSpringbootApplication {

	private String topic = "testapp";
	@Autowired
	private KafkaTemplate<String, Object> template;
	
	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name){
		template.send(topic, "Hi"+name+ "Welcome");
		return "Data Published";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringbootApplication.class, args);
	}

}
