package quhe;

import java.io.IOException;






import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pager.Pager;
import pager.Video;
import service.JdbcSqlVideoServiceImpl;
import service.VideoService;

public class BoFangServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2956143785004462886L;

	private VideoService videoService = new JdbcSqlVideoServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public BoFangServlet() {
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
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html");
		
		//接收id，返回name和address
		String video_idStr=req.getParameter("id");
		int video_id=Integer.parseInt(video_idStr);
		Video searchModel=new Video();
		searchModel.setVideo_id(video_id);
		Pager<Video> result = videoService.findVideo(searchModel, 1, 1);
		req.setAttribute("result", result);
		req.getRequestDispatcher("/bofang.jsp").forward(req,res);
		
		
		
		
		
		
		
		
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
