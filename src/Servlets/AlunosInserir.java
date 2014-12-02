package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDao;
import facade.AcademiaFacade;
import modelos.Aluno;
import modelos.Endereco;
import modelos.Pessoa;
import modelos.Usuario;

/**
 * Servlet implementation class AlunosInserir
 */
@WebServlet("/alunos-inserir")
public class AlunosInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlunosInserir() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/AlunosInserir.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Aluno aluno = new Aluno();

		aluno.setCelular(request.getParameter("celular"));
		aluno.setCpf(request.getParameter("cpf"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setNome(request.getParameter("nome"));
		aluno.setTelefoneFixo(request.getParameter("telefone"));

		Endereco e = new Endereco();
		e.setBairro(request.getParameter("bairro"));
		e.setCep(request.getParameter("cep"));
		e.setComplemento(request.getParameter("complemento"));
		e.setNumero(request.getParameter("numero") != null ? Integer
				.parseInt(request.getParameter("numero")) : 0);
		e.setRua(request.getParameter("rua"));
		 aluno.setEndereco(e);

		Usuario u = new Usuario();
		u.setLogin(request.getParameter("login"));
		u.setSenha(request.getParameter("senha"));

		aluno.setUsuario(u);

		AcademiaFacade.salvarAluno(aluno);

		response.sendRedirect("alunos-listar");

	}
}
