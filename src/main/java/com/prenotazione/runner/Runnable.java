package com.prenotazione.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.prenotazione.repository.Edificio_Dao;
import com.prenotazione.service.Prenotazione_Service;

@Component
public class Runnable implements ApplicationRunner{

	@Autowired Prenotazione_Service serviceFunctionality;
	@Autowired Edificio_Dao Edificio_InterfaceDao;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("run");
		// creo singole entità slegate
		//serviceFunctionality.CreateFPostazione(); <-- non mi serve perché le creo sotto
		serviceFunctionality.CreateFUtente();
		serviceFunctionality.CreateFEdificio();
		
		// creo diverse postazioni e le associo ad un edificio
		serviceFunctionality.CreateMultiplePostazioniAssociatedWithEdificio(Edificio_InterfaceDao.queryEdificioId1());
	}
}
