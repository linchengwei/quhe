package dao;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import dbtool.JdbcUtil;


import pager.Pager;
import pager.Video;

public class JdbcSqlVideoDaoImpl implements VideoDao {

	@Override
	public Pager<Video> findVideo(Video searchModel, int pageNum, int pageSize) {


		Pager<Video> result=null;
		List<Object> paramList=new ArrayList<Object>();
		//用户视频管理
		String user_id=searchModel.getUser_id();
		//视频播放界面
		int video_id=searchModel.getVideo_id();
		//视频搜索界面or分类界面
		String video_name=searchModel.getVideo_name();
		//视频浏览界面
		StringBuilder sql=new StringBuilder(
				"select * from videoinfo where 1=1");
		StringBuilder countSql=new StringBuilder(
				"select count(video_id) as totalRecord from videoInfo where 1=1");
		
		if(user_id!=null && !user_id.equals("")){
			sql.append(" and user_id=?");
			countSql.append(" and user_id=?");
			paramList.add(user_id);
			
		}
		if(video_id!=0){
			sql.append(" and video_id=?");
			countSql.append(" and video_id=?");
			paramList.add(video_id);
			
		}
		if(video_name!=null&&!video_name.equals("")){
			sql.append(" and video_name like ?");
			countSql.append(" and video_name like ?");
			paramList.add("%"+video_name+"%");
			
		}

		
		
		// 起始索引
		int fromIndex	= pageSize * (pageNum -1);
		
		// 使用limit关键字，实现分页
		sql.append(" limit " + fromIndex + ", " + pageSize );
		
		// 存放所有查询出的学生对象
		List<Video> videoList=new ArrayList<Video>();
		
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
			
			// 获取总记录数
			List<Map<String, Object>> countResult = jdbcUtil.findResult(countSql.toString(), paramList);
			Map<String, Object> countMap = countResult.get(0);
			int totalRecord = ((Number)countMap.get("totalRecord")).intValue();
			
			// 获取查询的学生记录
			List<Map<String, Object>> videoResult = jdbcUtil.findResult(sql.toString(), paramList);
			if (videoResult != null) {
				for (Map<String, Object> map : videoResult) {
					Video v=new Video(map);
					videoList.add(v);
					
				}
			}
			
			//获取总页数
			int totalPage = totalRecord / pageSize;
			if(totalRecord % pageSize !=0){
				totalPage++;
			}
			
			// 组装pager对象
			
			result = new Pager<Video>(pageSize, pageNum, 
							totalRecord, totalPage, videoList);
			
		} catch (SQLException e) {
			throw new RuntimeException("查询所有数据异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
		return result;
	}

}
