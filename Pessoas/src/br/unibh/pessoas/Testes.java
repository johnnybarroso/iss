package br.unibh.pessoas;


import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.persistencia.PessoaFisicaDAO;

public class Testes {
	@Test
	public void testePessoaFisicaFindAll(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		List<PessoaFisica> l = dao.findAll();
		Assert.assertEquals(l.size(), 100);
		
	}
	@Test
	public void testePessoaFisicaFind(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica p = dao.find(6L);
		Assert.assertEquals(p.getNome(), "Jeremy Z. Christian");
	}
	@Test
	public void testePessoaFisicaInserir()
	{
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica pf = new PessoaFisica(
				null, 
				"Fulano da Silva", 
				"Rua A", "3134914896", "11111111111", 
				"nome@tiberwar.com", new Date(), "M");
		dao.insert(pf);
		PessoaFisica pf2 = dao.find("Fulano da Silva");
		Assert.assertNotNull(pf2);
		dao.delete(pf2);
		PessoaFisica pf3 = dao.find("Fulano da Silva");
		Assert.assertNull(pf3);
	}
	@Test
	public void testePessoaFisicaAtualizar(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica pf = new PessoaFisica(
				null, 
				"Ciclano da Silva", 
				"Rua A", "3134914896", "26571325478", 
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
}
