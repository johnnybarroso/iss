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

import br.unibh.servicospessoas.entidades.PessoaJuridica;
import br.unibh.servicospessoas.persistencia.PessoaJuridicaDAO;

// The Java class will be hosted at the URI path "/pessoajuridica"
@Path("/pessoajuridica")
public class ServicoPessoaJuridicaRestJson {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public List<PessoaJuridica> listar() {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		return dao.findAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public PessoaJuridica find(@PathParam("id") int id) {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		return dao.find(new Long(id));
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/salvar")
	public PessoaJuridica salvar(PessoaJuridica p) {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		dao.insert(p);
		dao.update(p);
		return dao.findCnpj(p.getCnpj());
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public PessoaJuridica atualizar(@PathParam("id") int id, PessoaJuridica p) {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		dao.update(p);
		return dao.find(new Long(id));
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void deletarJSON(@PathParam("id") int id) {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica pj = dao.find(new Long(id));
		dao.delete(pj);
		PessoaJuridica pj2 = dao.find(new Long(id));
		if (pj2 == null) {
			System.out.println("Pessoa Juridica foi deletada com sucesso");
		} else {
			System.out.println("Erro ao deletar a Pessoa Juridica");
		}
	}
}
