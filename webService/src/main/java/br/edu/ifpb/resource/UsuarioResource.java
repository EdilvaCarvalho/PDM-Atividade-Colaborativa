/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.resource;


import br.edu.ifpb.service.UsuarioService;
import br.edu.ifpb.modelo.Usuario;
import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
 
/**
 *
 * @author laerton
 */
@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class UsuarioResource {
    private UsuarioService service = new UsuarioService();
    
    @GET
    @Path("{usuarioId}")
    public Usuario findUsuario(@PathParam("usuarioId") long id){
        return service.findUser(id);
    }
    
    @POST
    @Produces("application/json")
    public long save(String user){
        Gson gson = new Gson();
        Usuario u = gson.fromJson(user, Usuario.class);
        u = service.salvar(u);
        return u.getId(); //Response.status(Status.CREATED).entity(user).build();
    }
    
    @DELETE
    @Path("{usuarioId}")
    public void delete(@PathParam("usuarioId") long id){
        Usuario user = service.findUser(id);
        service.deletar(user);
    }
    
}
