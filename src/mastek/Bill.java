package mastek;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Bill
 */
public class Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Product p=(Product) request.getAttribute("product");
		
		out.println("<font color=red size=4> Your bill is <br>");
		out.println(p.getPid() + " <br>");
		out.println(p.getPname() + " <br>");
		out.println(p.getPrice() + " <br>");
		out.println(p.getQuantity() + " <br>");
		out.println(p.getBill() + " <br>");
		out.println( " <br><hr></font>");
		HttpSession session=request.getSession();
		
		ArrayList<Product> plist=(ArrayList<Product>)session.getAttribute("cart");
		if(plist==null)
		{
			plist=new ArrayList<Product>();
		}
		plist.add(p);
		session.setAttribute("cart",plist);
		out.println(" <a href=index.jsp> Add more Product </a><br>");
		out.println(" <a href=finaljsp.jsp>Final Bill </a><br>");
		
	}

}
