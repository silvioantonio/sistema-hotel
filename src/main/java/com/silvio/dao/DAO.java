/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.dao;

import com.silvio.model.Cadastro;
import java.util.List;

/**
 *
 * @author SILVIO
 * @param <T>
 */
public interface DAO<T extends Cadastro> {
    T findById(int id);
    T findByField(String fieldName, Object value);
    List<T> buscaHoteisCidade(int id);
    List<T> buscaHoteisBairro(int id);
    List<T> buscaHoteisCidadePrecoCamas(int id, double preco, int cama);
    boolean delete(T entity);
    boolean delete(int id);
    int save(T entity);

}
