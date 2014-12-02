package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Aluno;
import modelos.Instrutor;
import modelos.Usuario;
import facade.AcademiaFacade;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		try {
			Usuario usuario = AcademiaFacade.autentica(login, senha);

			if (usuario != null) {
				request.getSession()
						.setAttribute("id-usuario", usuario.getId());
				request.getSession().setAttribute("nome-usuario",
						usuario.getLogin());

				if (usuario.getPessoa() instanceof Instrutor) {
					response.sendRedirect("FichasListarInstrutor");
				} else if (usuario.getPessoa() instanceof Aluno) {
					response.sendRedirect("AvaliacoesListar");
				} else {
					response.sendRedirect("alunos-listar");
				}
			}
		} catch (Exception e) {
			response.sendRedirect("index.html");
		}

	}

}
