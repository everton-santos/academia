package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Exercicio;
import modelos.Modalidade;
import facade.AcademiaFacade;

/**
 * Servlet implementation class ExerciciosListar
 */
@WebServlet("/exercicios-listar")
public class ExerciciosListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExerciciosListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			String nome = request.getParameter("nome");

			java.util.List<Exercicio> lista;

			lista = AcademiaFacade.listaExercicoPorNome(nome);

			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/ExerciciosListar.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
