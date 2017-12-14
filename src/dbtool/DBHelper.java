package dbtool;

import java.sql.Connection;
import java.sql.DriverManager;
//SQL的JDBC
public class DBHelper {
   
	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //数据库驱动
	//连接数据库的URL地址
	private static final String url="jdbc:sqlserver://localhost:1433;DatabaseName=j2ee_user"; 
	private static final String username="j2ee";//数据库的用户名
	private static final String password="123456";//数据库的密码

	private static Connection conn=null;
	
	//静态代码块负责加载驱动
	static 
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//单例模式返回数据库连接对象
	public static Connection getConnection() throws Exception
	{
		if(conn==null)
		{
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	
	
}
