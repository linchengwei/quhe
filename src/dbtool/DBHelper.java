package dbtool;

import java.sql.Connection;
import java.sql.DriverManager;
//SQL��JDBC
public class DBHelper {
   
	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //���ݿ�����
	//�������ݿ��URL��ַ
	private static final String url="jdbc:sqlserver://localhost:1433;DatabaseName=j2ee_user"; 
	private static final String username="j2ee";//���ݿ���û���
	private static final String password="123456";//���ݿ������

	private static Connection conn=null;
	
	//��̬����鸺���������
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
	
	//����ģʽ�������ݿ����Ӷ���
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
