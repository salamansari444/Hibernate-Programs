package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.service.InsurancePolicyService;
import in.ineuron.service.InsurancePolicyServiceImpl;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(urlPatterns = "/controller" , loadOnStartup=1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InsurancePolicyService service;
	
	@Override
		public void init() throws ServletException {
			service= new InsurancePolicyServiceImpl();
		}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
		long pagesCount = service.fetchPagesCount(pageSize);
		int pageNo = 1;
		service.fetchPageData(pageSize, pageNo);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

	@Override
	public void destroy() {
		service = null;
	}
}
