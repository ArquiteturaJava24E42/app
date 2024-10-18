package br.edu.infnet.elberth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ElberthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElberthApplication.class, args);
	}

}
