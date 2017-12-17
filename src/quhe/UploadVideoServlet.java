package quhe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbtool.DBtool;

public class UploadVideoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9146137172845437003L;

	/**
	 * Constructor of the object.
	 */
	public UploadVideoServlet() {
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

		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();

		HttpSession session=request.getSession();
		int beginIndex,endIndex;
		beginIndex=0;
		endIndex=0;
		String v_http;
		
		try{
			Connection conn=DBtool.getConnection();
			Statement stmt=conn.createStatement();
			
			String v_name=new String(request.getParameter("videoname").getBytes("ISO-8859-1"),"utf-8");
			String v_address=request.getParameter("VideoAddress");
			String v_user_id=(String)session.getAttribute("userid");
			//截取视频地址
			//<iframe height=498 width=510 
			//src='http://player.youku.com/embed/XMzE3Mjk2NDY2OA==' 
			//frameborder=0 'allowfullscreen'></iframe>
			
			beginIndex=v_address.indexOf("http");
			endIndex=v_address.indexOf("' ");
			
			v_http=v_address.substring(beginIndex, endIndex);
			
			
			String sql = "insert into videoinfo(video_name,video_address,user_id) "
					+ "values('" + v_name + "', '" + v_http + "','"+ v_user_id+ "')";
			
			stmt.executeUpdate(sql);
			stmt.close();
			
			//out.println("<script language='javascript'>alert('success成功');</script>");
			//request.getRequestDispatcher("login.html").include(request, response);
			
			response.sendRedirect("SelfMes.html");
		}catch(Exception ex){
			ex.printStackTrace();
			response.sendRedirect("/quhe/index.jsp");
		}
		out.flush();
		out.close();
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

		doGet(request,response);
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
