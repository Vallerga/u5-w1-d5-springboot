package com.prenotazione.repository;

import org.springframework.data.repository.CrudRepository;

import com.prenotazioni.model.Utente;

public interface Utente_Dao extends CrudRepository<Utente, Long> {

}
