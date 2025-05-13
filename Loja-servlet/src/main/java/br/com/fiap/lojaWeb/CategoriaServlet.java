package br.com.fiap.lojaWeb;

import java.io.IOException;

import br.com.fiap.lojaclasses.Categoria;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public CategoriaServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Passei no get");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Passei no post");
		
		Categoria cat1 = new Categoria();
		
		cat1.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
		cat1.setDescricao(request.getParameter("descricao"));
		cat1.inserirCategoria();

		//redericiona para a pagina de cadastro
		request.getRequestDispatcher("Categoria.jsp").forward(request, response);
		
		doGet(request,response);
	}

}
