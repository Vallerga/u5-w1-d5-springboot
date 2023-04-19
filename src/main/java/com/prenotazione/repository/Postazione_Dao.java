package com.prenotazione.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prenotazione.model.Postazione;
import com.prenotazione.model.Tipo;

@Repository
public interface Postazione_Dao extends CrudRepository<Postazione, Long> {
	public List<Postazione> findByDescrizionePostazione(String descrizionePostazione);

	public List<Postazione> findByNumMaxOccupanti(Integer numMaxOccupanti);

	public List<Postazione> findByTipo(Tipo tipo);
}
