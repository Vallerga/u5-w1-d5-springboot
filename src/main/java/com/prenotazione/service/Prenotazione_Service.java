package com.prenotazione.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.prenotazione.model.Edificio;
import com.prenotazione.model.Postazione;
import com.prenotazione.model.Prenotazione;
import com.prenotazione.model.Utente;
import com.prenotazione.repository.Edificio_Dao;
import com.prenotazione.repository.Postazione_Dao;
import com.prenotazione.repository.Prenotazione_Dao;
import com.prenotazione.repository.Utente_Dao;

@Service
public class Prenotazione_Service {

    @Autowired
    private Edificio_Dao edificio_dao;
    @Autowired
    private Postazione_Dao postazione_dao;
    @Autowired
    private Utente_Dao utente_dao;
    @Autowired
    private Prenotazione_Dao prenotazione_dao;

    @Autowired
    @Qualifier("FakePostazione")
    private ObjectProvider<Postazione> FakePostazione;
    @Autowired
    @Qualifier("FakeEdificio")
    private ObjectProvider<Edificio> FakeEdificio;
    @Autowired
    @Qualifier("FakeUtente")
    private ObjectProvider<Utente> FakeUtente;

    @Autowired
    @Qualifier("FakePrenotazione")
    private ObjectProvider<Prenotazione> FakePrenotazione;

    public void CreateFPostazione() {
	insertPostazione(FakePostazione.getObject());

    }

    public void CreateFUtente() {
	insertUtente(FakeUtente.getObject());
    }

    public void CreateFEdificio() {
	insertEdificio(FakeEdificio.getObject());
    }

    public void CreateFPrenotazione() {
	insertPrenotazione(FakePrenotazione.getObject());
    }

    public void insertPostazione(Postazione p) {
	postazione_dao.save(p);
    }

    public void insertUtente(Utente u) {
	utente_dao.save(u);
    }

    public void insertEdificio(Edificio e) {
	edificio_dao.save(e);
    }

    public void insertPrenotazione(Prenotazione pre) {
	prenotazione_dao.save(pre);
    }

    public List<Postazione> CreateMultiplePostazioniAssociatedWithEdificio(Edificio edificio) {
	// creo lista di postazioni
	List<Postazione> listPostazioni = new ArrayList<Postazione>();

	// creo 3 FakePostazioni salvandole nel database
	Postazione p1 = postazione_dao.save(FakePostazione.getObject());
	Postazione p2 = postazione_dao.save(FakePostazione.getObject());
	Postazione p3 = postazione_dao.save(FakePostazione.getObject());

	// le aggiungo alla lista postazioni
	listPostazioni.add(p1);
	listPostazioni.add(p2);
	listPostazioni.add(p3);
	// ritorno la lista di postazioni
	return listPostazioni;
    }

    public List<Prenotazione> CreateMultiplePrenotazioniAssociatedWithUtente(Utente utente) {
	// creo lista di postazioni
	List<Prenotazione> listPrenotazioni = new ArrayList<Prenotazione>();

	// creo 3 FakePostazioni salvandole nel database
	Prenotazione pre1 = prenotazione_dao.save(FakePrenotazione.getObject());
	Prenotazione pre2 = prenotazione_dao.save(FakePrenotazione.getObject());
	Prenotazione pre3 = prenotazione_dao.save(FakePrenotazione.getObject());

	// le aggiungo alla lista postazioni
	listPrenotazioni.add(pre1);
	listPrenotazioni.add(pre2);
	listPrenotazioni.add(pre3);
	// ritorno la lista di postazioni
	return listPrenotazioni;
    }

    public List<Prenotazione> CreateMultiplePrenotazioniAssociatedWithPostazione(Postazione Postazione) {
	// creo lista di postazioni
	List<Prenotazione> listPrenotazioni = new ArrayList<Prenotazione>();

	// creo 3 FakePostazioni salvandole nel database
	Prenotazione pre1 = prenotazione_dao.save(FakePrenotazione.getObject());
	Prenotazione pre2 = prenotazione_dao.save(FakePrenotazione.getObject());
	Prenotazione pre3 = prenotazione_dao.save(FakePrenotazione.getObject());

	// le aggiungo alla lista postazioni
	listPrenotazioni.add(pre1);
	listPrenotazioni.add(pre2);
	listPrenotazioni.add(pre3);
	// ritorno la lista di postazioni
	return listPrenotazioni;
    }
}
