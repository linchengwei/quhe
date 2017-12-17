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
		//��ȡ��Ƶ����
		/**
		 * �õ�jsp���������ݣ��������в�ѯ���ٴ��ݸ���Ӧ��jsp
		 * 
		 */
		/**
		 * 1.��Ƶ���Ž���ᴫ��videoid
		 * 
		 * 2.��Ƶ��������ᴫ��videoname
		 * 3.��Ƶ�������ᴫ��videoname����videosort
		 * 4.��Ƶ�������ᴫ��userid
		 * ����һ��result��jspҳ�洦��result���������
		 */
		
		String video_idStr=req.getParameter("video_id");
		String video_name=req.getParameter("video_name");
		String user_id=req.getParameter("user_id");
		
		
		
		// У��pageNum��������Ϸ���
		String pageNumStr = req.getParameter("pageNum"); 
		if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
			req.setAttribute("errorMsg", "�����������");
			req.getRequestDispatcher("jdbcSqlStudent.jsp").forward(req, res);
			return;
		}
		int pageNum = Constant.DEFAULT_PAGE_NUM; //��ʾ�ڼ�ҳ����
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		int pageSize = Constant.DEFAULT_PAGE_SIZE;  // ÿҳ��ʾ��������¼
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
		
		// ���ؽ����ҳ��
		request.setAttribute("result", result);
		request.setAttribute("stuName", stuName);
		request.setAttribute("gender", gender);
		
		//�ض���
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
