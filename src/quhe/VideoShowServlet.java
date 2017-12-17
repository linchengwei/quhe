package quhe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pager.Constant;
import pager.Pager;
import pager.Video;
import service.JdbcSqlVideoServiceImpl;
import service.VideoService;
import dbtool.StringUtil;



public class VideoShowServlet extends HttpServlet {

	
	private static final long serialVersionUID = -7759842967211035664L;

	private VideoService videoService = new JdbcSqlVideoServiceImpl();
	
	public VideoShowServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html");
		//获取视频内容
		/**
		 * 得到jsp传来的内容，到服务中查询，再传递给对应的jsp
		 * 
		 */
		/**
		 * 1.视频播放界面会传来videoid
		 * 
		 * 2.视频搜索界面会传来videoname
		 * 3.视频分类界面会传来videoname或者videosort
		 * 4.视频管理界面会传来userid
		 * 返回一个result，jsp页面处理result里面的数据
		 */
		
		String video_idStr=req.getParameter("video_id");
		String video_name=req.getParameter("video_name");
		String user_id=req.getParameter("user_id");
		
		
		
		// 校验pageNum参数输入合法性
		String pageNumStr = req.getParameter("pageNum"); 
		if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
			req.setAttribute("errorMsg", "参数传输错误");
			req.getRequestDispatcher("jdbcSqlStudent.jsp").forward(req, res);
			return;
		}
		int pageNum = Constant.DEFAULT_PAGE_NUM; //显示第几页数据
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		int pageSize = Constant.DEFAULT_PAGE_SIZE;  // 每页显示多少条记录
		String pageSizeStr = req.getParameter("pageSize");
		if(pageSizeStr!=null && !"".equals(pageSizeStr.trim())){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		Video searchModel=new Video();
		if(user_id!=null&&!user_id.equals("")){
			int video_id=Integer.parseInt(video_idStr);
			searchModel.setVideo_id(video_id);
		}
		
		searchModel.setVideo_name(video_name);
		searchModel.setUser_id(user_id);
		
		Pager<Video> result = videoService.findVideo(searchModel, pageNum, pageSize);
		//video_address
		req.setAttribute("result", result);
		//video_name
		req.setAttribute("video_name", video_name);
		//video_img_path
		
		req.getRequestDispatcher("/jdbcSql/myVideo.jsp").forward(req,res);
		
		
		/**
		 * 
		
		// 返回结果到页面
		request.setAttribute("result", result);
		request.setAttribute("stuName", stuName);
		request.setAttribute("gender", gender);
		
		//重定向
		request.getRequestDispatcher("jdbcSqlStudent.jsp").forward(request, response);
		 */
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
