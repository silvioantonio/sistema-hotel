/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author SILVIO
 */
@Entity
@Table(name="hotel")
public class Hotel implements Serializable, Cadastro {

    @Id
    @SequenceGenerator(name = "id_hotel", sequenceName = "id_hotel", allocationSize = 1)
    @GeneratedValue(generator = "id_hotel",strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length=80)
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Quarto> quartos;
    
    @ManyToOne
    @JoinColumn(columnDefinition = "id_bairro")
    private Bairro bairro;
    
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
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
        final Hotel other = (Hotel) obj;
        return this.id == other.id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    /*public List<Quarto> getQuartos() {
    return quartos;
    }*/

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
}
