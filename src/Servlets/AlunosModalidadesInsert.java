package Servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Aluno;
import modelos.AlunoModalidade;
import modelos.Modalidade;
import dao.AlunoDao;
import dao.AlunoModalidadeDao;
import dao.ModalidadeDao;

/**
 * Servlet implementation class AlunosModalidadesInsert
 */
@WebServlet("/AlunosModalidadesInsert")
public class AlunosModalidadesInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlunosModalidadesInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AlunoModalidade am = new AlunoModalidade();

		int idAluno = Integer.parseInt(request.getParameter("idAluno"));
		AlunoDao adao = new AlunoDao();
		Aluno a = new Aluno();
		a.setId(idAluno);
		am.setAluno(adao.consultarPorID(a));

		am.setDataInscricao(new Date());

		int idModalidade = Integer.parseInt(request.getParameter("modalidade"));
		ModalidadeDao mdao = new ModalidadeDao();
		Modalidade m = new Modalidade();
		m.setId(idModalidade);

		am.setModalidade(mdao.consultarPorID(m));

		AlunoModalidadeDao dao = new AlunoModalidadeDao();
		dao.salvar(am);

		response.sendRedirect("AlunosModalidades?id=" + idAluno);
	}

}
