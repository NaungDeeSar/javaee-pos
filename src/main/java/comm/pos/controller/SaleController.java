package comm.pos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/sale_history"},loadOnStartup = 1)
public class SaleController extends HttpServlet {


	private static final long serialVersionUID = 1L;
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  String action =req.getServletPath(); 	     
 	     if("/sale_history".equals(action)) {
 	    		req.setAttribute("title", "salehistory");
 	    		getServletContext().getRequestDispatcher("/sale_history.jsp").forward(req, resp);
 	   		 
 	     }
    }
}
