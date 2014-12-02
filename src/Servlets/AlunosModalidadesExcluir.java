package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.AlunoModalidade;
import dao.AlunoModalidadeDao;

/**
 * Servlet implementation class AlunosModalidadesExcluir
 */
@WebServlet("/AlunosModalidadesExcluir")
public class AlunosModalidadesExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunosModalidadesExcluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idM"));
		AlunoModalidadeDao dao = new AlunoModalidadeDao();
		AlunoModalidade a = new AlunoModalidade();
		a.setId(id);
		dao.remover(a);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/AlunosModalidades?id="+request.getParameter("id"));
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
