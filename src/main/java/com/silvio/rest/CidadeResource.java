/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.rest;

import com.silvio.dao.DAO;
import com.silvio.model.Bairro;
import com.silvio.model.Cidade;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author SILVIO
 */
@Path("/cidade")
@Transactional
public class CidadeResource {
    @Inject
    private DAO<Cidade> dao;
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cidade findById(@PathParam("id") int id){
    return dao.findById(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public int insert(Cidade cidade) {
        return dao.save(cidade);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean update(Cidade cidade) {
        //Se retornou um id maior que 0, é porque o usuário foi salvo no BD
        return dao.save(cidade) > 0;
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") int id) {
        return dao.delete(id);
    }
}
