package com.prenotazioni.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.prenotazione.service.Prenotazione_Service;
import com.prenotazioni.model.Edificio;
import com.prenotazioni.model.Postazione;
import com.prenotazioni.model.Tipo;
import com.prenotazioni.model.Utente;

//import com.jpac_project.service.UserService;

@Component
public class Prenotazione_Runner implements ApplicationRunner {

	@Autowired
	Prenotazione_Service prenotazione;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		prenotazione.FakePostazione();
	}
	
}