package comm.pos.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.pos.model.entity.Category;
import comm.pos.model.entity.Item;
import comm.pos.model.service.CategoryService;
import comm.pos.model.service.ItemService;


@WebServlet(urlPatterns = {"","/home"},loadOnStartup = 1)
public class HomeController extends HttpServlet{	
	private static final long serialVersionUID = 1L;	
	 private EntityManagerFactory emf;
	 private CategoryService catservice;
	 private ItemService itemservice;
@Override
public void init() throws ServletException {	
	super.init();	
	Object object=getServletContext().getAttribute("EntityManagerFactory");
    if(object==null) {
    	emf=Persistence.createEntityManagerFactory("javaEE-14");
    	getServletContext().setAttribute("EntityManagerFactory", object);
    }
    catservice=new  CategoryService(emf.createEntityManager()); 
    itemservice=new  ItemService(emf.createEntityManager()); 
	   List <Category> list=catservice.findAll();	    	   	 
	   getServletContext().setAttribute("categories", list);	
}
	
@Override
public void destroy() {
	if(emf!=null && emf.isOpen())
		emf.close();
		
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String action =req.getServletPath();		     
		     if("/home".equals(action) || "".equals(action)) {	
		    	 //retrieve item
		    	 List<Item> list=itemservice.findAll();
		    	 //add list
		    	 req.setAttribute("items", list);
		    	 //invoke index.jsp
		    		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		    		
		     }
		     
		
	}

}
