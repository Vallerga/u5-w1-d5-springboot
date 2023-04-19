package com.prenotazione.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.prenotazione.repository.Edificio_Dao;
import com.prenotazione.repository.Postazione_Dao;
import com.prenotazione.repository.Utente_Dao;
import com.prenotazione.service.Prenotazione_Service;

@Component
public class Runnable implements ApplicationRunner {

    @Autowired
    Prenotazione_Service serviceFunctionality;
    @Autowired
    Edificio_Dao Edificio_InterfaceDao;
    @Autowired
    Utente_Dao Utente_InterfaceDao;
    @Autowired
    Postazione_Dao Postazione_InterfaceDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
	System.out.println("run");
	// creo singole entità slegate
	// serviceFunctionality.CreateFPostazione(); <-- non mi serve perché le creo
	// sotto
	serviceFunctionality.CreateFUtente();
	serviceFunctionality.CreateFEdificio();
	serviceFunctionality.CreateFPrenotazione();

	// creo diverse postazioni e le associo ad un edificio
	serviceFunctionality.CreateMultiplePostazioniAssociatedWithEdificio(Edificio_InterfaceDao.queryEdificioId1());
	// creo diverse prenotazioni e le associo ad un utente
	serviceFunctionality.CreateMultiplePrenotazioniAssociatedWithUtente(Utente_InterfaceDao.queryUtenteId1());
	// creo diverse prenotazioni e le associo ad un postazione
	serviceFunctionality
		.CreateMultiplePrenotazioniAssociatedWithPostazione(Postazione_InterfaceDao.queryPostazioneId1());
    }
}
