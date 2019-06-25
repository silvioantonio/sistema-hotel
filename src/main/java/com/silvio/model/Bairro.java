/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
@Table(name="bairro")
public class Bairro implements Serializable, Cadastro {

    @Id
    @SequenceGenerator(name = "id_bairro", sequenceName = "id_bairro", allocationSize = 1)
    @GeneratedValue(generator = "id_bairro", strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 50)
    private String nome;
    
    @OneToMany(mappedBy = "bairro",cascade = CascadeType.ALL)
    private List<Hotel> hoteis;
    
    @ManyToOne
    @JoinColumn(columnDefinition = "id_cidade", referencedColumnName = "id")
    private Cidade cidade;
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.nome);
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
        final Bairro other = (Bairro) obj;
        return this.id == other.id;
    }

    public void setHoteis(List<Hotel> hoteis) {
        this.hoteis = hoteis;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
}
