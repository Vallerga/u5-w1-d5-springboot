package com.prenotazione.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prenotazione.model.Utente;

public interface Utente_Dao extends CrudRepository<Utente, Long> {
	public List<Utente> findByCognome(String cognome);

    public List<Utente> findByEmail(String email);

    public List<Utente> findByNome(String nome);
}
