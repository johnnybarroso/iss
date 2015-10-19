
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

import br.unibh.servicospessoas.entidades.CEP;
import br.unibh.servicospessoas.persistencia.CEPDAO;

// The Java class will be hosted at the URI path "/pessoafisica"
@Path("/cep")
public class ServicoCEPRestJson {

    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<CEP> listar(){
    	CEPDAO dao = new CEPDAO();
    	return dao.findAll();
    }
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar2")
    public List<CEP> listar(@PathParam("endereco") String endereco){
    	CEPDAO dao = new CEPDAO();
    	return dao.findCep(endereco);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cep}")
    public CEP find(@PathParam("cep") int id){
		CEPDAO dao = new CEPDAO();
    	return dao.find(new Long(id));	
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/salvar")
    public CEP salvar(CEP p){
    	CEPDAO dao = new CEPDAO();
    	dao.insert(p);
    	dao.update(p);
    	return dao.findCep(p.getCep());
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{cep}")
    public CEP atualizar(@PathParam("cep") int id, CEP p)
    {
    	CEPDAO dao = new CEPDAO();
    	dao.update(p);
    	return dao.find(new Long(id));
    }
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{cep}")
    public void deletarJSON(@PathParam("cep") int id) {
    	 CEPDAO dao = new CEPDAO();
    	 CEP cp = dao.find(new Long(id));
 		 dao.delete(cp);
 		 CEP cp2 = dao.find(new Long(id));
 		 if(cp2 == null)
 		 {
 			 System.out.println("CEP Excluido");
 		 }
 		 else
 		 {
 			 System.out.println("Erro ao deletar o CEP");
 		 }
    }
}
