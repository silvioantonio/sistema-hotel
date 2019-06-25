/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author SILVIO
 */
@Entity
@Table(name="quarto")
public class Quarto implements Serializable, Cadastro {
    
    @Id
    @SequenceGenerator(name = "id_quarto", sequenceName = "id_quarto", allocationSize = 1)
    @GeneratedValue(generator = "id_quarto", strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="numero_do_quarto", nullable = false, length = 3)
    private int numeroDoQuarto;
    
    @Column(name="quantidade_de_camas", length = 2)
    private int quantidadeDeCamas;
    
    @Column(precision = 2)
    private double preco;
    
    @Column(length = 2)
    private int andar;

    @ManyToOne
    private Hotel hotel;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.numeroDoQuarto;
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
        final Quarto other = (Quarto) obj;
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

    public int getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(int numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public int getQuantidadeDeCamas() {
        return quantidadeDeCamas;
    }

    public void setQuantidadeDeCamas(int quantidadeDeCamas) {
        this.quantidadeDeCamas = quantidadeDeCamas;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAndar() {
        return andar;
    } 

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    
}
