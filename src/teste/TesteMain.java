package teste;

import dao.AlunoDao;
import modelos.Aluno;
import modelos.Endereco;


public class TesteMain {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		
		aluno.setNome("Everton");
		
		Endereco endereco = new Endereco();
		endereco.setNumero(36);
		
		aluno.setEndereco(endereco);

		AlunoDao dao = new AlunoDao();
		dao.salvar(aluno);
		
		
	}

}
