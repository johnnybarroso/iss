package br.unibh.pessoas.persistencia;

import java.sql.ResultSet;
import java.util.List;

import br.unibh.pessoas.entidades.PessoaFisica;

public class PessoaFisicaDAO implements DAO<PessoaFisica, Long>{

	@Override
	public PessoaFisica find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(PessoaFisica t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PessoaFisica t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PessoaFisica t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PessoaFisica> findAll() {
		try {
			ResultSet res = JDBCUtil.getConnection().prepareStatement(
					  "select * from tb_pessoa_fisica").executeQuery();
			while (res.next()){
				System.out.println(res.getString("nome")+" - "+res.getString("email"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
		}
		return null;
	}

}
