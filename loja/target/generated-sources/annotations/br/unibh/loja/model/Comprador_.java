package br.unibh.loja.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Comprador.class)
public abstract class Comprador_ {

	public static volatile SingularAttribute<Comprador, Long> id;
	public static volatile SingularAttribute<Comprador, String> telefone2;
	public static volatile SingularAttribute<Comprador, String> email;
	public static volatile SingularAttribute<Comprador, String> sexo;
	public static volatile SingularAttribute<Comprador, Date> dataNascimento;
	public static volatile SingularAttribute<Comprador, String> cpf;
	public static volatile SingularAttribute<Comprador, String> nome;
	public static volatile SingularAttribute<Comprador, String> telefone1;
	public static volatile SingularAttribute<Comprador, Date> dataCadastro;
	public static volatile SingularAttribute<Comprador, String> endereco;

}

