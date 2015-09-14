package br.unibh.pessoas;

import java.util.Date;

import br.unibh.pessoas.entidades.Pessoa;
import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.entidades.PessoaJuridica;
import br.unibh.pessoas.persistencia.PessoaFisicaDAO;

public class Main {

	public static void main(String args[]) {
		
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		dao.findAll();

	}

}
