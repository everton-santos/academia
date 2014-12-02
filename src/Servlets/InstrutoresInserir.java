package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InstrutorDao;
import modelos.Aluno;
import modelos.Endereco;
import modelos.Instrutor;
import modelos.Usuario;
import facade.AcademiaFacade;

/**
 * Servlet implementation class InstrutoresInserir
 */
@WebServlet("/instrutores-inserir")
public class InstrutoresInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrutoresInserir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/InstrutoresInserir.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Instrutor aluno = new Instrutor();

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

		AcademiaFacade.salvarInstrutor(aluno);

		response.sendRedirect("instrutores-listar");
	}

}
