package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Aluno;
import modelos.Endereco;
import modelos.Instrutor;
import modelos.Usuario;
import dao.InstrutorDao;
import facade.AcademiaFacade;

/**
 * Servlet implementation class InstrutoresEditar
 */
@WebServlet("/IntrutoresEditar")
public class InstrutoresEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrutoresEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		InstrutorDao dao = new InstrutorDao();
		Instrutor a = new Instrutor();
		a.setId(id);
		a = dao.consultarPorID(a);
		request.setAttribute("aluno", a);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/InstrutoresAlterar.jsp");
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
		aluno.setId(Integer.parseInt(request.getParameter("ida")));

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
		u.setId(Integer.parseInt(request.getParameter("idu")));

		aluno.setUsuario(u);

		AcademiaFacade.salvarInstrutor(aluno);

		response.sendRedirect("instrutores-listar");
	}

}
