package dao;

import modelos.Pessoa;

public class PessoaDao  extends DaoGenerico<Pessoa>{

	@Override
	protected Class<Pessoa> getEntityClass() {
		return Pessoa.class;
	}
	
}
