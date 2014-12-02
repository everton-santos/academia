package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Aluno;
import modelos.Modalidade;
import dao.AlunoDao;
import facade.AcademiaFacade;

/**
 * Servlet implementation class AlunosModalidades
 */
@WebServlet("/AlunosModalidades")
public class AlunosModalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunosModalidades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AlunoDao dao = new AlunoDao();
		Aluno a = new Aluno();
		a.setId(id);
		a = dao.consultarPorID(a);
		request.setAttribute("aluno", a);
		java.util.List<Modalidade> modalidades = AcademiaFacade.listaModalidades();
		request.setAttribute("modalidades", modalidades);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/AlunosModalidades.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
