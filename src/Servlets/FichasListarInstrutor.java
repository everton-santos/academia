package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Aluno;
import modelos.Ficha;
import modelos.Instrutor;
import modelos.Modalidade;
import modelos.Usuario;
import dao.UsuarioDao;
import facade.AcademiaFacade;

/**
 * Servlet implementation class FichasListarInstrutor
 */
@WebServlet("/FichasListarInstrutor")
public class FichasListarInstrutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FichasListarInstrutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getSession()
				.getAttribute("id-usuario").toString());
		
		String modalidadeS = request.getParameter("modalidade");
		
		
		UsuarioDao dao = new UsuarioDao();
		Usuario aluno = new Usuario();
		aluno.setId(id);
		Instrutor a = (Instrutor) dao.consultarPorID(aluno).getPessoa();

		List<Ficha> fichas ;
		
		if (modalidadeS != null) {
			int idM = Integer.parseInt(modalidadeS);
			fichas = new ArrayList<Ficha>();
			for (Ficha ficha : a.getFichas()) {
				if (ficha.getAlunoModalidade().getModalidade().getId() == idM) {
					fichas.add(ficha);
				}
			}
		}
		else
		{
			fichas = a.getFichas();
		}
		
		request.setAttribute("lista", fichas);
		
		java.util.List<Modalidade> modalidades = AcademiaFacade.listaModalidades();
		request.setAttribute("modalidades", modalidades);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/FichasListarInstrutor.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
