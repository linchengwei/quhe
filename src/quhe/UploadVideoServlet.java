package quhe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import dbtool.DBtool;

public class UploadVideoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9146137172845437003L;

	private File smartFile;
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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		HttpSession session=request.getSession();
		int beginIndex,endIndex;
		beginIndex=0;
		endIndex=0;
		String v_http="";
		String v_name="";
		String v_address="";
		String v_user_id="";
		
		/**
		 * �����
		 * 
		 */
		SimpleDateFormat sim=null;
		StringBuffer sbf=new StringBuffer();
        //����ʱ���
		sim=new SimpleDateFormat("yyyymmddhhmmssSSS");
		sbf.append(sim.format(new Date()));
		
        Random random=new Random();                        //Ҫ���������
        for(int i=0;i<5;i++){                            //����5λ�����
                sbf.append(random.nextInt(10));                //ÿλ�������������10
        }
       
        String sb=sbf.toString();
		
		
		try{
			Connection conn=DBtool.getConnection();
			Statement stmt=conn.createStatement();
			
			SmartUpload smartUpload = new SmartUpload();
			// ��ʼ��
		    ServletConfig config = this.getServletConfig();
		    smartUpload.initialize(config, request, response);
		  try {
		            // �ϴ��ļ�
		            smartUpload.upload();
		            // �õ��ϴ����ļ�����
		            smartFile = smartUpload.getFiles().getFile(0);
		            // �����ļ�
		            System.out.println(smartFile.getFileName());
		            
		            //session.setAttribute("touxiang", smartFile.getFileName());
		            //smartFile.saveAs(this.getServletContext().getRealPath("/")+"img/" + smartFile.getFileName(),smartUpload.SAVE_AUTO);
		            smartFile.saveAs(this.getServletContext().getRealPath("/")+"img/" + sb);
		            //,smartUpload.SAVE_AUTO
		            //String ext = smartUpload.getFiles().getFile(0).getFileExt();// ����ļ���׺
		            //smartUpload.getFiles().getFile(0).saveAs(this.getServletContext().getRealPath("/")+filename+"."+ext); // ���Ϊ�Զ����ļ���
		            //filename�����ļ��Զ������ƣ�ext�����ļ���չ����
		            
		            v_name=new String(smartUpload.getRequest().getParameter("videoname").getBytes("ISO-8859-1"),"utf-8");
					v_address=smartUpload.getRequest().getParameter("VideoAddress");
					v_user_id=(String)session.getAttribute("userid");
					//��ȡ��Ƶ��ַ
					//<iframe height=498 width=510 
					//src='http://player.youku.com/embed/XMzE3Mjk2NDY2OA==' 
					//frameborder=0 'allowfullscreen'></iframe>
					
					beginIndex=v_address.indexOf("http");
					endIndex=v_address.indexOf("' ");
					
					v_http=v_address.substring(beginIndex, endIndex);
		            
		            
		            
		            
		        } catch (SmartUploadException e) {
		            e.printStackTrace();
		        }
		      
      
		        
		        //��ͷ����ļ������浽���ݿ���û�����
		        String video_img_path =new String(smartFile.getFileName().getBytes("ISO-8859-1"),"utf-8");
	
			
			String sql = "insert into videoinfo(video_name,video_address,user_id,video_img) "
					+ "values('" + v_name + "', '" + v_http + "','"+ v_user_id+ "','"+video_img_path+ "')";
			
			stmt.executeUpdate(sql);
			stmt.close();
			
			//out.println("<script language='javascript'>alert('success�ɹ�');</script>");
			request.getRequestDispatcher("SucessUpdated.html").forward(request, response);;
			
			//response.sendRedirect("SelfMes.html");
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
