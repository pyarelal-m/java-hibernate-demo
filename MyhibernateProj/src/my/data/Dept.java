package my.data;
public class Dept
{
	private int id;
	private String dname;
	private String loc;
	public void setId(int deptNo)
	{
		this.id=deptNo;
	}
	public int getId()
	{
		return id;
	}
	public void setDname(String dname)
	{
		this.dname=dname;
	}
	public String getDname()
	{
		return dname;
	}
	public void setLoc(String loc)
	{
		this.loc=loc;
	}
	public String getLoc()
	{
		return loc;
	}
}
