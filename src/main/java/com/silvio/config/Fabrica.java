/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.config;

import com.silvio.dao.DAO;
import com.silvio.dao.JpaDAO;
import com.silvio.model.Cadastro;
import java.lang.reflect.ParameterizedType;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SILVIO
 */
public class Fabrica {
    
    @Produces
    @PersistenceContext//notaçao que gera EntityManager sempre que a classe for chamada
    private EntityManager em;
    
    @Produces
    public <T extends Cadastro> DAO<T> getDao(InjectionPoint ip){
        ParameterizedType p = (ParameterizedType) ip.getType();
        //transforma em classe meu objeto do indice 0 do tipo parametrizado
        Class classe = (Class) p.getActualTypeArguments()[0];
        return new JpaDAO(em, classe);
    }
}
