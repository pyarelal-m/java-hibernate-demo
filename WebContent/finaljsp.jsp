<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,mastek.Product,mastek.ProductDAO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
double sum=0.0;
ArrayList<Product> plist=(ArrayList<Product>) session.getAttribute("cart");
if(plist!=null)
{
	ProductDAO dao=new ProductDAO();
	for(Product p:plist)
	{
		out.println("<font color=red size=4> Your bill is <br>");
		out.println(p.getPid() + " <br>");
		out.println(p.getPname() + " <br>");
		out.println(p.getPrice() + " <br>");
		out.println(p.getQuantity() + " <br>");
		out.println(p.getBill() + " <br>");
		out.println( " <br><hr>");
		sum=sum+p.getBill();
		dao.insertProducttoCart(p);	
	}
	out.println( " <br><hr>Final bill is "+sum+"/-Rs </font>");
}

%>
</body>
</html>