/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.rest;

import com.silvio.dao.DAO;
import com.silvio.model.Reserva;
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
@Path("/reserva-quarto")
@Transactional
public class ReservaQuarto {
    @Inject
    private DAO<Reserva> dao;
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reserva findById(@PathParam("id") int id){
        return dao.findById(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public int insert(Reserva reserva) {
        return dao.save(reserva);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public int update(Reserva reserva) {
        return dao.save(reserva);
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") int id) {
        return dao.delete(id);
    }
}