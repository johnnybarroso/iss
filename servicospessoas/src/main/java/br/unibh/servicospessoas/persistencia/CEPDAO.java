package br.unibh.servicospessoas.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unibh.servicospessoas.entidades.CEP;

public class CEPDAO implements DAO<CEP, Long>{

	public List<CEP> findCep(String endereco){
		List<CEP> lista = new ArrayList<CEP>();
		try {
			ResultSet res = JDBCUtil.getConnection().prepareStatement(
					  "select * from tb_cep").executeQuery();
			while (res.next()){
				lista.add(new CEP(
						res.getLong("cep"),
						res.getString("endereco"),
						res.getString("cidade")
						)
					);
				//System.out.println(res.getString("nome")+" - "+res.getString("email"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return lista;
	}
	
	@Override
	public CEP find(Long cep) {
		try {
			PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(
					  "select * from tb_cep "
					+ "where cep = ?");
			p.setLong(1, cep);
			ResultSet res = p.executeQuery();
			if (res.next()){
				return new CEP(
						res.getLong("cep"),
						res.getString("endereco"),
						res.getString("cidade")
						);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}
	
	public CEP findCep(Long cep) {
		try {
			PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(
					  "select * from tb_cep "
					+ "where cep = ?");
			p.setLong(1, cep);
			ResultSet res = p.executeQuery();
			if (res.next()){
				return new CEP(
						res.getLong("cep"),
						res.getString("endereco"),
						res.getString("cidade")
						);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}
	
	public CEP find(String endereco) {
		try {
			PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(
					  "select * from tb_cep "
					+ "where endereco like ?");
			p.setString(1, endereco+"%");
			ResultSet res = p.executeQuery();
			if (res.next()){
				return new CEP(
						res.getLong("cep"),
						res.getString("endereco"),
						res.getString("cidade")
						);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}

	
	@Override
	public void insert(CEP t) {
		// TODO Auto-generated method stub
				try {
					PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(
							  "insert into tb_cep "
							+ "(cep, endereco, "
						    + "cidade) values "
							+ "(?,?,?)");
					p.setLong(1, t.getCep());
					p.setString(2, t.getEndereco());
					p.setString(3, t.getCidade());
					p.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					JDBCUtil.closeConnection();
				}
				//return null;		
	}

	@Override
	public void update(CEP t) {
		try {
			PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(
					"update tb_cep set cep = ?, endereco = ?, cidade = ? where cep = ?");
			p.setLong(1, t.getCep());
			p.setString(2, t.getEndereco());
			p.setString(3, t.getCidade());
			p.setLong(4, t.getCep());
			p.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public void delete(CEP t) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(
							  "delete from tb_cep "
							+ "where cep = ?");
					p.setLong(1, t.getCep());
					p.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					JDBCUtil.closeConnection();
				}
				//return null;
	}

	@Override
	public List<CEP> findAll() {
		List<CEP> lista = new ArrayList<CEP>();
		try {
			ResultSet res = JDBCUtil.getConnection().prepareStatement(
					  "select * from tb_cep").executeQuery();
			while (res.next()){
				lista.add(new CEP(
						res.getLong("cep"),
						res.getString("endereco"),
						res.getString("cidade")
						)
					);
				//System.out.println(res.getString("nome")+" - "+res.getString("email"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return lista;
	}
}
