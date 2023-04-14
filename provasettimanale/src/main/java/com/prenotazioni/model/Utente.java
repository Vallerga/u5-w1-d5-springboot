package com.prenotazioni.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Utente {
    private String cognome;
    private String nome;
    private String email;
    private Postazione postazione;
}