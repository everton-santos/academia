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
import dao.ModalidadeDao;

/**
 * Servlet implementation class ModadlidadesEditar
 */
@WebServlet("/ModalidadesEditar")
public class ModadlidadesEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModadlidadesEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ModalidadeDao dao = new ModalidadeDao();
		Modalidade a = new Modalidade();
		a.setId(id);
		a = dao.consultarPorID(a);
		request.setAttribute("entidade", a);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ModalidadesAlterar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Modalidade m = new Modalidade();
		m.setNome(request.getParameter("nome"));
		m.setId(Integer.parseInt(request.getParameter("id")));
		ModalidadeDao dao = new ModalidadeDao();
		dao.salvar(m);
		response.sendRedirect("modalidades-listar");
	}

}
