package com.prenotazioni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prenotazione.configuration.Prenotazioni_Configuration;

@SpringBootApplication
public class ProvasettimanaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Prenotazioni_Configuration.class, args);
	}

}
