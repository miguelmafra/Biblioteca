package br.up.edu.arquitetura.biblioteca.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.up.edu.arquitetura.biblioteca.modelo.dominio.Autor;
import br.up.edu.arquitetura.biblioteca.modelo.dominio.Emprestimo;
import br.up.edu.arquitetura.biblioteca.modelo.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.modelo.dominio.Mutuario;
import br.up.edu.arquitetura.biblioteca.modelo.negocio.EmprestimoNegocio;
import br.up.edu.arquitetura.biblioteca.modelo.negocio.LivroNegocio;
import br.up.edu.arquitetura.biblioteca.modelo.negocio.MutuarioNegocio;

@Path("api/emprestimos")
public class EmprestimoRest {
	
    private EmprestimoNegocio bc = new EmprestimoNegocio();   
    private MutuarioNegocio mc = new MutuarioNegocio();
    private LivroNegocio lc = new LivroNegocio();

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Emprestimo> find(@QueryParam("q") String query) throws Exception {
    	//if(bc.listarTodos().size() == 0 ) {
    		//Autor autor = new Autor();
    		//Mutuario mutuario = new Mutuario("Miguel","Brasileiro");
    		//Livro livro = new Livro("A caminho da Luz", 123, "Está querendo sair das trevas",autor);
    	//}
    	return bc.listarTodos();
	}

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Emprestimo load(@PathParam("id") int id) throws Exception {
    	Emprestimo result = null;
    	
    	for(Emprestimo m : bc.listarTodos()) {
    		if(m.getId() == id) {
    			result = m;
    		}
    	}

        if (result == null) {
            throw new NotFoundException();
        }

        return result;
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response insert(Emprestimo emprestimo, @Context UriInfo uriInfo) throws Exception {
       
    	emprestimo.setLivro(lc.listarTodos().get(emprestimo.getLivro().getId()));
    	emprestimo.setMutuario(mc.listarTodos().get(emprestimo.getMutuario().getId()));
        String id = ""+bc.cadastra(emprestimo).getId();
        URI location = uriInfo.getRequestUriBuilder().path(id).build();

        return Response.created(location).entity(id).build();
    }

    @PUT
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public void update(@PathParam("id") int id, Emprestimo emprestimo) throws Exception {

        bc.atualizar(emprestimo);
    }
    
    @DELETE
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public void delete(@PathParam("id") int id) throws Exception {
    	for(Emprestimo m : bc.listarTodos()) {
    		if(m.getId() == id) {
    			bc.delete(m);
    			break;
    		}
    	}
    }


}
