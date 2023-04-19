package com.prenotazione.configuration;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.prenotazione.model.Edificio;
import com.prenotazione.model.Postazione;
import com.prenotazione.model.Tipo;
import com.prenotazione.model.Utente;
import com.prenotazione.repository.Edificio_Dao;

@Configuration
@PropertySource("classpath:application.properties")
public class Prenotazioni_Configuration {
	// richiamo la query per selezionare edificio 1
	@Autowired Edificio_Dao Edificio_InterfaceDao;

    @Bean("ParamsPostazione")
    @Scope("prototype")
    public Postazione postazioneCrea(String descrizionePostazione, Tipo tipo, Integer numMaxOccupanti,
	    Edificio edificio) {
	return new Postazione(null, descrizionePostazione, tipo, numMaxOccupanti, edificio);
    }

    @Bean("ParamsEdificio")
    @Scope("prototype")
    public Edificio edificioCrea(String nome, String indirizzo, String città, List<Postazione> listaPostazione) {
	return new Edificio(null, nome, indirizzo, città, listaPostazione);
    }

    @Bean("ParamsUtente")
    @Scope("prototype")
    public Utente utenteCrea(String cognome, String nome, String email) {
	return new Utente(null, cognome, nome, email);
    }

    @Bean("FakePostazione")
    @Scope("prototype")
    public Postazione fakePostazionee() {
	Faker fake = Faker.instance(new Locale("it-IT"));
	Postazione p = new Postazione();
	p.setDescrizionePostazione(fake.company().name());
	p.setNumMaxOccupanti(fake.number().numberBetween(20, 40));
	p.setTipo(Tipo.OPENSPACE);
	p.setEdificio(Edificio_InterfaceDao.queryEdificioId1());
	return p;
    }

    @Bean("FakeEdificio")
    @Scope("prototype")
    public Edificio fakeEdificio() {
	Faker fake = Faker.instance(new Locale("it-IT"));
	Edificio e = new Edificio();
	e.setCittà(fake.address().cityName());
	e.setIndirizzo(fake.address().streetName());
	e.setNome(fake.funnyName().name());
	return e;
    }

    @Bean("FakeUtente")
    @Scope("prototype")
    public Utente fakeUtente() {
	Faker fake = Faker.instance(new Locale("it-IT"));
	Utente u = new Utente();
	u.setCognome(fake.name().lastName());
	u.setNome(fake.name().firstName());
	u.setEmail(u.getNome() + "." + u.getCognome() + "@gmail.com");
	return u;
    }

}