package facade;

import java.util.ArrayList;
import java.util.List;

import modelos.Aluno;
import modelos.Instrutor;
import modelos.Modalidade;
import modelos.Usuario;
import dao.AlunoDao;
import dao.InstrutorDao;
import dao.ModalidadeDao;
import dao.UsuarioDao;

public class AcademiaFacade {
	
	
	
	public static Usuario autentica(String login, String senha){
		//CriarAdmin();
		
		UsuarioDao dao = new UsuarioDao();
		return dao.autentica(login, senha);
	}
	
	public static List<Aluno> listaAlunoPorNome(String nome){
		if (nome == null) {
			nome = "";
		}
		AlunoDao dao = new AlunoDao();
		List<Aluno> alunos = dao.getListaPorNome(nome);
		
		if (alunos == null) {
			alunos = new ArrayList<Aluno>();
		}
		
		return alunos;
	}
	
	public static List<Instrutor> listaInstrutorPorNome(String nome){
		if (nome == null) {
			nome = "";
		}
		InstrutorDao dao = new InstrutorDao();
		List<Instrutor> alunos = dao.getListaPorNome(nome);
		
		if (alunos == null) {
			alunos = new ArrayList<Instrutor>();
		}
		
		return alunos;
	}
	
	public static List<Aluno> listaAlunoPorNomeModalidade(String nome, int idModalidade){
		if (nome == null) {
			nome = "";
		}
		if (idModalidade == 0) {
			return listaAlunoPorNome(nome);
		}
		AlunoDao dao = new AlunoDao();
		List<Aluno> alunos = dao.getListaPorNomeModalidade(nome, idModalidade);
		
		if (alunos == null) {
			alunos = new ArrayList<Aluno>();
		}
		return alunos;
	}
	
	
	public static List<Modalidade> listaModalidades()
	{
		ModalidadeDao dao = new ModalidadeDao();
		List<Modalidade> list = dao.listar(new Modalidade());
		
		if (list == null) {
			list = new ArrayList<Modalidade>();
		}
		return list;
		
	}
	
	public static void salvarAluno(Aluno aluno){
		AlunoDao da = new AlunoDao();
		UsuarioDao du = new UsuarioDao();
		du.salvar(aluno.getUsuario());
		da.salvar(aluno);
		
	}
	
	private static void CriarAdmin(){
		
		if (listaAlunoPorNome("admin").size() <= 0) {
			UsuarioDao dao = new UsuarioDao();
			Usuario admin = new Usuario();
			admin.setLogin("admin");
			admin.setSenha("123");
			dao.salvar(admin);
		}
		
	}

	public static List<Modalidade> listaModalidadePorNome(String nome) {
		if (nome == null) {
			nome = "";
		}
		ModalidadeDao dao = new ModalidadeDao();
		List<Modalidade> alunos = dao.getListaPorNome(nome);
		
		if (alunos == null) {
			alunos = new ArrayList<Modalidade>();
		}
		
		return alunos;
	}
	
}
