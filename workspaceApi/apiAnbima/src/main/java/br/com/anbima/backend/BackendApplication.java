package br.com.anbima.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.anbima.backend.infraestrutura.ConfigMemEstrutura;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
	
	@Autowired
	private ConfigMemEstrutura configMenEstrutura;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Inicializando o db...");
		configMenEstrutura.loadInit();
		
	}
	
	
} 
