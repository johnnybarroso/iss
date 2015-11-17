package br.unibh.loja.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, Long> id;
	public static volatile SingularAttribute<Produto, BigDecimal> preco;
	public static volatile SingularAttribute<Produto, String> nomeFornecedor;
	public static volatile SingularAttribute<Produto, String> cnpjFornecedor;
	public static volatile SingularAttribute<Produto, String> marca;
	public static volatile SingularAttribute<Produto, Date> dataCadastro;
	public static volatile SingularAttribute<Produto, String> descricao;

}

