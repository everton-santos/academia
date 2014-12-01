package facade;

import java.util.List;

import dao.AlunoDao;
import dao.UsuarioDao;
import modelos.Aluno;
import modelos.Usuario;

public class AcademiaFacade {
	
	public static Usuario autentica(String login, String senha){
		UsuarioDao dao = new UsuarioDao();
		
		return dao.autentica(login, senha);
	}
	
	public static List<Aluno> listaAlunoPorNome(String nome){
		AlunoDao dao = new AlunoDao();
		List<Aluno> alunos = dao.getListaPorNome(nome);
		return alunos;
	}
	
	public static List<Aluno> listaAlunoPorNomeModalidade(String nome, int idModalidade){
		AlunoDao dao = new AlunoDao();
		List<Aluno> alunos = dao.getListaPorNomeModalidade(nome, idModalidade);
		return alunos;
	}
	
}
