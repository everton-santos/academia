package teste;

import dao.PessoaDao;
import modelos.Pessoa;

public class TesteMain {

	public static void main(String[] args) {
		
		Pessoa p = new Pessoa();
		p.setCelular("1231321");
		p.setNome("Everton");
		p.setCpf("546465465");
		
		PessoaDao dao = new PessoaDao();
		dao.salvar(p);
		

	}

}
