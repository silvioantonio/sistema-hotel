package com.silvio.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author SILVIO
 */
@Entity
@Table(name="reserva")
public class Reserva  implements Serializable, Cadastro{

    @Id
    @SequenceGenerator(name = "reserva_id", sequenceName = "reserva_id", allocationSize = 1)
    @GeneratedValue(generator = "reserva_id", strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 80)
    private String nome;
    
    @Column(name = "data_chegada")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataChegada;
    
    @Column(name = "data_partida")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPartida;
    
    @ManyToOne
    @JoinColumn(columnDefinition = "id_hotel")
    private Hotel hotel;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        return this.id == other.id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) throws ParseException {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate ld = LocalDate.parse(dataChegada,dt);
        this.dataChegada = java.sql.Date.valueOf(ld);
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        Date data = null;
        try {
            data = new SimpleDateFormat("dd-MM-yyyy").parse(dataPartida);
        } catch (ParseException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dataPartida = data;
    }

    public Hotel getQuarto() {
        return hotel;
    }

    public void setQuarto(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
