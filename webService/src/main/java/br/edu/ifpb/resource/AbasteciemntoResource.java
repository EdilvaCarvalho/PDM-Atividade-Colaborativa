/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.resource;
import br.edu.ifpb.service.AbastecimentoService;
import br.edu.ifpb.service.PostoService;
import br.edu.ifpb.modelo.Abastecimento;

import br.edu.ifpb.modelo.TipoDeCombustivel;
import com.google.gson.Gson;


import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;



/**
 *
 * @author laerton
 */
@Path("/Abastecimentos")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class AbasteciemntoResource {
    private AbastecimentoService service = new AbastecimentoService();
    private PostoService servicePosto = new PostoService();
    
   
    @GET
    @Path("ultimo/{postoId}/{tipo}")
    //@Produces({MediaType.APPLICATION_XML,       MediaType.APPLICATION_JSON})
    public Abastecimento findUltimoAbastCombustivel( @PathParam("postoId")long postoId, @PathParam("tipo") String tipo){
        //PostoDeCombustivel posto = servicePosto.findPosto(postoId);
        
        return service.findValorCombustivel(TipoDeCombustivel.valueOf(tipo), postoId);
    }
    
    @GET
    @Path("postoAndUser/{postoId}/{userId}")
    public Collection<Abastecimento> findByPostoAndUser(@PathParam("postoId") long postoId, @PathParam("userId") long userId){
        return service.findByPostoAndUser(userId, postoId);
    }
    
    @GET
    @Path("byUser/{userId}")
    public Collection<Abastecimento> findByUser(@PathParam("userId") long userId){
        return service.findByUser(userId);
    }
    
    @GET
    @Path("{abastecimentoId}")
    public Abastecimento findById(@PathParam("abastecimentoId") long Id){
        return service.findAbastecimento(Id);
    }
    
    @POST
    //@Path("{abastecimento}")
    public Abastecimento salvar(String abastecimento){
        Gson g = new Gson();
        Abastecimento a = g.fromJson(abastecimento, Abastecimento.class);
        service.salvar(a);
        return a; //Response.status(Status.CREATED).entity(abastecimento).build();
    }
    
    @DELETE
    @Path("{abasteciemntoId}")
    public void delete (@PathParam("abastecimentoId") long id){
        Abastecimento ab = service.findAbastecimento(id);
        service.deletar(ab);
    }
}
