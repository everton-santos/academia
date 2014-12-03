package Servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Aluno;
import modelos.Avaliacao;
import modelos.Instrutor;
import modelos.Medicao;
import modelos.MedidaAvaliacao;
import modelos.Usuario;
import dao.AlunoDao;
import dao.AvaliacaoDao;
import dao.MedicaoDao;
import dao.MedidaAvaliacaoDao;
import dao.UsuarioDao;

/**
 * Servlet implementation class AvaliacoesInsertInstrutor
 */
@WebServlet("/AvaliacoesInserirInstrutor")
public class AvaliacoesInsertInstrutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvaliacoesInsertInstrutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("alunos", new AlunoDao().listar(new Aluno()));

		request.setAttribute("medidas",
				new MedicaoDao().listar(new Medicao()));

		List<MedidaAvaliacao> lista  = new MedidaAvaliacaoDao().listar(new MedidaAvaliacao());
		
		request.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/AvaliacoesInserirInstrutor.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAluno = Integer.parseInt(request.getParameter("aluno"));

		int idMedida = Integer.parseInt(request.getParameter("medida"));

		int valor = Integer.parseInt(request.getParameter("valor"));


		Aluno a = new Aluno();
		a.setId(idAluno);

		AlunoDao dA = new AlunoDao();
		Aluno aluno = dA.consultarPorID(a);

		MedidaAvaliacao ma = new MedidaAvaliacao();
		
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setAluno(aluno);
		avaliacao.setData(new Date());
		AvaliacaoDao avDao  = new AvaliacaoDao();
		avDao.salvar(avaliacao);
		
		ma.setAvaliacao(avaliacao);
		
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(request.getSession()
				.getAttribute("id-usuario").toString()));
		Instrutor inst = (Instrutor) dao.consultarPorID(usuario).getPessoa();
		
		ma.setInstrutor(inst);
		
		Medicao m = new Medicao();
		m.setId(idMedida);
		MedicaoDao mDao = new MedicaoDao();
		Medicao medicao = mDao.consultarPorID(m);
		ma.setMedicao(medicao);
		
		ma.setValor(valor);
		
		MedidaAvaliacaoDao maDao = new MedidaAvaliacaoDao();
		maDao.salvar(ma);
		
		response.sendRedirect("AvaliacoesInserirInstrutor");
	}

}
