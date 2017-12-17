package quhe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbtool.DBtool;

public class LoginServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1150789479290341075L;

	public LoginServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String userid=request.getParameter("Account");
		String password=request.getParameter("PassWord");
		
		try{
			Connection conn=DBtool.getConnection();
			Statement stmt=conn.createStatement();
			String sql="select user_id,password from userinfo";
			ResultSet rs=stmt.executeQuery(sql);
			//5.��������
			while(rs.next()){
				if(rs.getString(1).equals(userid)){//ͨ�����ύ���˺Ŵ����ݿ����ҳ�Ҫ��֤���û�
					break;
				}
			}
			
			if(rs.getString(2).equals(password)){//�Ƚ�����
				out.print("��¼�ɹ�");
				HttpSession session=request.getSession();
				
				session.setAttribute("userid",userid);//��¼״̬��1
				
				//�����û�id
				//session.setAttribute("user_no", rs.getString("user_no"));
//				if(rs.getString("user_no").equals("admin")){
//					session.setAttribute("admin", "1");
//				}
				//������ת��
				//request.getRequestDispatcher("goods2.jsp").forward(request, response);
				rs.close();
				stmt.close();
				
				response.sendRedirect("../index2.html");
			}else{
			/* 	out.print("�û��������������"); */
				rs.close();
				stmt.close();
				
				out.println("<script language='javascript'>alert('�������!');</script>");
				//request.getRequestDispatcher("sign_in.jsp").include(request, response);
			}
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			out.println("<script language='javascript'>alert('�û�������!�������쳣��');</script>");
			response.sendRedirect("/quhe/index.jsp");
			//request.getRequestDispatcher("sign_in.jsp").include(request, response);
		}

		
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
