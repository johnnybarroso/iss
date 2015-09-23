package br.unibh.pessoas;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.entidades.PessoaJuridica;
import br.unibh.pessoas.persistencia.PessoaFisicaDAO;
import br.unibh.pessoas.persistencia.PessoaJuridicaDAO;

public class Testes {
	// Pessoa Fisica
	@Test
	public void testePessoaFisicaFindAll() {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		List<PessoaFisica> l = dao.findAll();
		Assert.assertEquals(l.size(), 100);

	}

	@Test
	public void testePessoaFisicaFind() {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica p = dao.find(6L);
		Assert.assertEquals(p.getNome(), "Jeremy Z. Christian");
	}

	@Test
	public void testePessoaFisicaInserir() {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica pf = new PessoaFisica(null, "Fulano da Silva", "Rua A", "3134914896", "22222111111",
				"nome@tiberwar.com", new Date(), "M");
		dao.insert(pf);
		PessoaFisica pf2 = dao.find("Fulano da Silva");
		Assert.assertNotNull(pf2);
		dao.delete(pf2);
		PessoaFisica pf3 = dao.find("Fulano da Silva");
		Assert.assertNull(pf3);
	}

	@Test
	public void testePessoaFisicaAtualizar() {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica pf = new PessoaFisica(null, "Ciclano da Silva", "Rua A", "3134914896", "26571325478",
				"ciclano@tiberwar.com", new Date(), "M");
		dao.insert(pf);
		PessoaFisica pf2 = dao.find("Ciclano da Silva");
		pf2.setNome("Beltrano da Silva");
		pf2.setEmail("beltrano@gmail.com");
		dao.update(pf2);
		PessoaFisica pf3 = dao.find("Beltrano da Silva");
		Assert.assertEquals(pf3.getEmail(), "beltrano@gmail.com");
		Assert.assertNotNull(pf3);
		dao.delete(pf3);
	}

	// PESSOA JURIDICA
	@Test
	public void testePessoaJuridicaFindAll() {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		List<PessoaJuridica> l = dao.findAll();
		Assert.assertEquals(l.size(), 100);

	}

	@Test
	public void testePessoaJuridicaFind() {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica p = dao.find(6L);
		Assert.assertEquals(p.getNome(), "Purus Accumsan Interdum Limited");
	}
	
	@Test
	public void testePessoaJuridicaInserir()
	{
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica pj = new PessoaJuridica(
				null, 
				"Johnny Tabajara LTDA", 
				"Rua Ciclano da Silveira", "3134821321", 
				"87994636032184", new Date(), "www.tabajarasjohnny.com.br");
		dao.insert(pj);
		PessoaJuridica pj2 = dao.find("Johnny Tabajara LTDA");
		Assert.assertNotNull(pj2);
		dao.delete(pj2);
		PessoaJuridica pj3 = dao.find("Johnny Tabajara LTDA");
		Assert.assertNull(pj3);
	} 
	
	@Test
	public void testePessoaJuridicaAtualizar() {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica pj = new PessoaJuridica(null, "Tabajara Ciclano", "Rua Eugenio Costa", 
				"3134912321", "12345621234511", new Date(), "www.sitesrl.xo.cz");
		dao.insert(pj);
		PessoaJuridica pj2 = dao.find("Tabajara Ciclano");
		pj2.setNome("Beltrano Tabajara");
		pj2.setEndereco("Rua Tabajaras Futebol");
		dao.update(pj2);
		PessoaJuridica pj3 = dao.find("Beltrano Tabajara");
		Assert.assertEquals(pj3.getEndereco(), "Rua Tabajaras Futebol");
		Assert.assertNotNull(pj3);
		dao.delete(pj3);
	}
}
