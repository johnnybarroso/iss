package br.unibh.pessoas;

import java.util.Date;

import br.unibh.pessoas.entidades.Pessoa;
import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.entidades.PessoaJuridica;

public class Main {

	public static void main(String args[]) {
		
		PessoaFisica pf1 = new PessoaFisica(1L, "João", "Rua A", "3333-4444", "11234563121", "joao@gmail.com", new Date(), "M");
		PessoaJuridica pj1 = new PessoaJuridica(2L,"Realizações LTDA", "Rua B", "3344-5555", "121488744", new Date(), "www.tiberawar.com");
		
		System.out.println(pf1);
		System.out.println(pj1);

	}

}
