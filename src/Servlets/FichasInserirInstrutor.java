package Servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Aluno;
import modelos.AlunoModalidade;
import modelos.Exercicio;
import modelos.Ficha;
import modelos.FichaExercicio;
import modelos.Instrutor;
import modelos.Modalidade;
import modelos.Usuario;
import dao.AlunoDao;
import dao.AlunoModalidadeDao;
import dao.ExercicioDao;
import dao.FichaDao;
import dao.FichaExercicioDao;
import dao.ModalidadeDao;
import dao.UsuarioDao;

/**
 * Servlet implementation class FichasInserirInstrutor
 */
@WebServlet("/FichasInserirInstrutor")
public class FichasInserirInstrutor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FichasInserirInstrutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("alunos", new AlunoDao().listar(new Aluno()));

		request.setAttribute("exercicios",
				new ExercicioDao().listar(new Exercicio()));

		request.setAttribute("lista",
				new FichaExercicioDao().listar(new FichaExercicio()));

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/FichasInserirInstrutor.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int idAluno = Integer.parseInt(request.getParameter("aluno"));

		int idExercicio = Integer.parseInt(request.getParameter("exercicio"));

		int qtdNumSerie = Integer.parseInt(request.getParameter("qtdSeries"));

		int qtdRepeticoes = Integer.parseInt(request
				.getParameter("qtdRepeticoes"));

		Aluno a = new Aluno();
		a.setId(idAluno);

		AlunoDao dA = new AlunoDao();
		Aluno aluno = dA.consultarPorID(a);

		FichaExercicio fe = new FichaExercicio();

		if (aluno.getAlunoModalidades().size() == 0) {
			AlunoModalidade am = new AlunoModalidade();
			am.setAluno(aluno);
			am.setModalidade(new ModalidadeDao().listar(new Modalidade())
					.get(0));
			AlunoModalidadeDao amDao = new AlunoModalidadeDao();
			amDao.salvar(am);
		}

		Ficha f = new Ficha();
		f.setAlunoModalidade(aluno.getAlunoModalidades().get(0));
		f.setData(new Date());
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(request.getSession()
				.getAttribute("id-usuario").toString()));

		Instrutor inst = (Instrutor) dao.consultarPorID(usuario).getPessoa();
		f.setInstrutor(inst);
		f.setPeriodo(3);

		FichaDao fDao = new FichaDao();
		fDao.salvar(f);
		fe.setFicha(f);

		Exercicio e = new Exercicio();
		e.setId(idExercicio);
		ExercicioDao dE = new ExercicioDao();
		Exercicio exercicio = dE.consultarPorID(e);

		fe.setExercicio(exercicio);

		fe.setQtdRepeticoes(qtdRepeticoes);
		fe.setQtdSeries(qtdNumSerie);

		FichaExercicioDao feDao = new FichaExercicioDao();
		feDao.salvar(fe);
		
		response.sendRedirect("FichasInserirInstrutor");
	}

}
