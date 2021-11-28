package mastek;
import java.sql.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;
public class ProductDAO {
	private Connection con;
	private PreparedStatement pst;
	public void makeConnection()
	{
		try
		{
			InitialContext context=new InitialContext();
			DataSource ds=(DataSource) context.lookup("java:jdbc/OracleDS");
			con=ds.getConnection();
			System.out.println("Connected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void releaseConnection()
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void insertProducttoCart(Product p)
	{
		try
		{
			makeConnection();
			pst=con.prepareStatement("insert into product values(?,?,?,?,?)");
			pst.setInt(1,p.getPid());
			pst.setString(2, p.getPname());
			pst.setDouble(3, p.getPrice());
			pst.setInt(4, p.getQuantity());
			pst.setDouble(5, p.getBill());
			pst.execute();
			con.commit();
			releaseConnection();
			System.out.println("inserted");
		}
		catch(Exception e)
		{
			//con.rollback();
			//con.close();
			e.printStackTrace();
		}
	}
}
