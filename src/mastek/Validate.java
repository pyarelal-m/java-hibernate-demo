package mastek;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s_pid=request.getParameter("pid");
		int pid=Integer.parseInt(s_pid);
		
		String s_pname=request.getParameter("pname");
		
		String s_price=request.getParameter("price");
		double price=Double.parseDouble(s_price);
		
		String qn=request.getParameter("qn");
		int quantity=Integer.parseInt(qn);
		
		double bill=price*quantity;
		
		Product p=new Product(bill,pid,s_pname,price,quantity); 
		
		request.setAttribute("product",p);
		
		RequestDispatcher red=request.getRequestDispatcher("Bill.view");
		red.forward(request, response);
		
		
	}

}
