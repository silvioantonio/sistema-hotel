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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author SILVIO
 */
@Entity
@Table(name="estado")
public class Estado implements Serializable, Cadastro {

    @Id
    @SequenceGenerator(name = "estado_id", sequenceName = "estado_id", allocationSize = 1)
    @GeneratedValue(generator = "estado_id" ,strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length=75)
    private String nome;
    
    @Column(length=5)
    private String uf;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private List<Cidade> cidades;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final Estado other = (Estado) obj;
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
    
    /*public List<Cidade> getCidades() {
    return cidades;
    }*/

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
