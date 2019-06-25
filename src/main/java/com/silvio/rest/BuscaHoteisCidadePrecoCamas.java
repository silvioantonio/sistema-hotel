/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.rest;

import com.silvio.dao.DAO;
import com.silvio.model.Bairro;
import com.silvio.model.Hotel;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author SILVIO
 */
@Path("/busca-hoteis-cidade-preco-camas")
@Transactional
public class BuscaHoteisCidadePrecoCamas {
    @Inject
    private DAO<Hotel> dao;
    
    @GET
    @Path("{cidade}/{preco}/{cama}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> buscaHoteisCidadePrecoCamas(@PathParam("cidade") int id, 
            @PathParam("preco") double preco, @PathParam("cama") int cama){
        return dao.buscaHoteisCidadePrecoCamas(id, preco, cama);
    }
}
//      @PathParam("preco") double preco, @PathParam("camas") int camas