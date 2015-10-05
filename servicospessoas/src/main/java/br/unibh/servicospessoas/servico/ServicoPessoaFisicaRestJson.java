
package br.unibh.servicospessoas.servico;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unibh.servicospessoas.entidades.PessoaFisica;
import br.unibh.servicospessoas.persistencia.PessoaFisicaDAO;

// The Java class will be hosted at the URI path "/pessoafisica"
@Path("/pessoafisica")
public class ServicoPessoaFisicaRestJson {

    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<PessoaFisica> listar(){
    	PessoaFisicaDAO dao = new PessoaFisicaDAO();
    	return dao.findAll();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public PessoaFisica find(@PathParam("id") int id){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
    	return dao.find(new Long(id));	
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/salvar")
    public PessoaFisica salvar(PessoaFisica p){
    	PessoaFisicaDAO dao = new PessoaFisicaDAO();
    	dao.insert(p);
    	dao.update(p);
    	return dao.findCpf(p.getCpf());
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public PessoaFisica atualizar(@PathParam("id") int id, PessoaFisica p)
    {
    	PessoaFisicaDAO dao = new PessoaFisicaDAO();
    	dao.update(p);
    	return dao.find(new Long(id));
    }
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void deletarJSON(@PathParam("id") int id) {
    	 PessoaFisicaDAO dao = new PessoaFisicaDAO();
    	 PessoaFisica pf = dao.find(new Long(id));
 		 dao.delete(pf);
 		 PessoaFisica pf2 = dao.find(new Long(id));
 		 if(pf2 == null)
 		 {
 			 System.out.println("Pessoa Fisica foi deletada com sucesso");
 		 }
 		 else
 		 {
 			 System.out.println("Erro ao deletar a Pessoa Fisica");
 		 }
    }
}
