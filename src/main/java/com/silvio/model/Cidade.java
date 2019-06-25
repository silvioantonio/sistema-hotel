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
@Table(name="cidade")
public class Cidade implements Serializable, Cadastro {

    @Id
    @SequenceGenerator(name = "id_cidade", sequenceName = "id_cidade", allocationSize = 1)
    @GeneratedValue(generator = "id_cidade" ,strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length=120)
    private String nome;
    
    @OneToMany(mappedBy = "cidade",cascade = CascadeType.ALL)
    private List<Bairro> bairros;
    
    @ManyToOne
    @JoinColumn(name="estado_id", referencedColumnName = "id")
    private Estado estado;
    
    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
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
        final Cidade other = (Cidade) obj;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
