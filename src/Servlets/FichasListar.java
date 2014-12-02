package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Aluno;
import modelos.Usuario;
import dao.UsuarioDao;

/**
 * Servlet implementation class FichasListar
 */
@WebServlet("/FichasListar")
public class FichasListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FichasListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getSession()
				.getAttribute("id-usuario").toString());
		UsuarioDao dao = new UsuarioDao();
		Usuario aluno = new Usuario();
		aluno.setId(id);
		Aluno a = (Aluno) dao.consultarPorID(aluno).getPessoa();

		request.setAttribute("lista", a.getAvaliacoes());
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/FichasListar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
