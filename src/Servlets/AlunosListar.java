package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ModalidadeDao;
import facade.AcademiaFacade;
import modelos.Aluno;
import modelos.Modalidade;
import antlr.collections.List;

/**
 * Servlet implementation class AlunosListar
 */
@WebServlet("/alunos-listar")
public class AlunosListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlunosListar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String nome = request.getParameter("nome");
		
		java.util.List<Modalidade> modalidades = AcademiaFacade.listaModalidades();
		request.setAttribute("modalidades", modalidades);
		
		java.util.List<Aluno> lista = AcademiaFacade.listaAlunoPorNome(nome);
		request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/AlunosListar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
