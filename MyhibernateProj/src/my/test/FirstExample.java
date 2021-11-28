package my.test;
import my.data.Dept;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Hibernate;
import org.hibernate.criterion.*;
import java.util.List;
import org.hibernate.cfg.Configuration;

public class FirstExample 
{
	public static void main(String[] args) 
	{
		try
		{
			
			Configuration cfg =new Configuration();
			//cfg.addFile("Dept.hbm.xml");
			//cfg.addClass(my.data.Dept.class);
           SessionFactory factory =cfg.configure().buildSessionFactory();
			System.out.println("Starting Program");
			//This step will read hibernate.cfg.xml and prepare hibernate for use
			//SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			System.out.println("Created SessionFactory");
			Session session=factory.openSession();
			System.out.println("Session Created");
			//Create new instance of Contact and set values in it by reading them from form object
		//	System.out.println("Inserting Record");
			Transaction tr=session.beginTransaction();
			//insert Code
		/*	Dept dept=new Dept();
			dept.setId(50);
			dept.setDname("ADMIN");
			session.save(dept);  */
			// update code
/*	Dept dept=(Dept)session.get(my.data.Dept.class,new Integer(50));
			dept.setLoc("Mumbai");
			session.update(dept);*/
			// Hibernate Native sql //Query 1
			/* String query="select count(DEPTNO) from DEPT";
			Query q= session.createSQLQuery(query);
			List l=q.list();
			System.out.println("Number of Rows in Departments are "+l.get(0));*/
			//// Hibernate Native sql //Query 2
			String query="select d.* from Dept d";
	Query q= session.createSQLQuery(query).addEntity("d",Dept.class);
			List l=q.list();
			for(Object o:l)
			{	
				System.out.println(o);
				Dept d=(Dept)o;
				System.out.println("Department ID "+d.getId());
				System.out.println("Department Name "+d.getDname());
				//System.out.println("Department Loc"+d.getLoc());
				System.out.println("----------------------");
			}
			// QUERY FOUR -- not proper
		//	String query="select d.dname as dname from Dept d";
		//	Query q= session.createSQLQuery(query).
                    //addScalar("dname",Hibernate.STRING);
	//		List l=q.list();
	//		for(Object o:l)
	//		{	
	//			System.out.println(o);				
	//			System.out.println("----------------------");
	//		}
			// -- not proper
			session.flush();
			tr.commit();
			session.close();
			System.out.println("Done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
				
		}
		finally
		{
			// Actual contact insertion will happen at this step
			//session.flush();
			//session.close();
		}
	}
}
