/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.dao;

import com.silvio.model.Cadastro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author SILVIO
 * @param <T>
 */
public class JpaDAO<T extends Cadastro> implements DAO<T> {

    private final EntityManager em;
    private final Class<T> classe;
    
    public JpaDAO(EntityManager em, Class<T> classe){
        this.em = em;
        this.classe = classe;
    }
    
    @Override
    public T findById(int id) {
        return em.find(classe, id);
    }

    @Override
    public boolean delete(T entity) {
        em.remove(entity);
        return true;
    }

    @Override
    public boolean delete(int id) {
        return delete(findById(id));
    }

    @Override
    public int save(T entity) {
        if(entity.getId() > 0)
            em.merge(entity);
        else em.persist(entity);

        return entity.getId();
    }

    @Override
    public T findByField(String fieldName, Object value) {
        final String jpql = "from " + classe.getSimpleName() + " o " +
                            " where o." + fieldName + " = :" + fieldName;
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setParameter(fieldName, value);
        return query.getSingleResult();
    }
    
    @Override
    public List<T> buscaHoteisCidade(int id){
        final String jpql =  
                "select ht "
                + "from "+classe.getSimpleName()+" as ht join "
                +"ht.bairro br"
                + " where br.cidade.id = :parametro";
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setParameter("parametro", id);
        return query.getResultList();
    }

    @Override
    public List<T> buscaHoteisBairro(int id) {
        final String jpql =  
                "select ht "
                + "from "+classe.getSimpleName()+" as ht join "
                +"ht.bairro br where br.id = :parametro";
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setParameter("parametro", id);
        return query.getResultList();
    }

    @Override
    public List<T> buscaHoteisCidadePrecoCamas(int id, double preco, int cama) {
        final String jpql = "select hotel from "+classe.getSimpleName()+" as hotel "
                + "where hotel.bairro.id in (select bairro.id from Bairro bairro "
                + "where bairro.cidade.id = :parametro) and hotel.id in ("
                + "select quarto.hotel.id from Quarto quarto "
                + "where quarto.preco = :parametro2 and "
                + "quarto.quantidadeDeCamas = :parametro3)";
        Query query = em.createQuery(jpql, classe);
        query.setParameter("parametro", id);
        query.setParameter("parametro2", preco);
        query.setParameter("parametro3", cama);
        return query.getResultList();
    }
    
}
