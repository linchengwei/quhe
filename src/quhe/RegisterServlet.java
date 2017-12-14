package quhe;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import dbtool.*;
public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		/*out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");*/
		
		
		try{
			Connection conn=DBtool.getConnection();
			Statement stmt=conn.createStatement();
			String u_id =new String(request.getParameter("Account").getBytes("ISO-8859-1"),"utf-8");
			String u_pwd = request.getParameter("PassWord1");
			String phone =request.getParameter("Phone");
			String sql = "insert into userinfo(user_id,password,tel) "
					+ "values('" + u_id + "', '" + u_pwd +"','"+phone+ "')";
			stmt.executeUpdate(sql); //为什么返回int值。
//			**5、处理结果(ResultSet)
			//out.println("" + rows + " row(s) inserted.");
			
//			6、关闭查询及连接
			stmt.close();
			
			//out.println("<script language='javascript'>alert('success成功');</script>");
			//request.getRequestDispatcher("login.html").include(request, response);
			
			response.sendRedirect("../login.html");
		}catch(Exception ex){
			ex.printStackTrace();
			response.sendRedirect("/quhe/index.jsp");
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
