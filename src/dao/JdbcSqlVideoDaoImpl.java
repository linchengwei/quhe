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
		//�û���Ƶ����
		String user_id=searchModel.getUser_id();
		//��Ƶ���Ž���
		int video_id=searchModel.getVideo_id();
		//��Ƶ��������or�������
		String video_name=searchModel.getVideo_name();
		//��Ƶ�������
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

		
		
		// ��ʼ����
		int fromIndex	= pageSize * (pageNum -1);
		
		// ʹ��limit�ؼ��֣�ʵ�ַ�ҳ
		sql.append(" limit " + fromIndex + ", " + pageSize );
		
		// ������в�ѯ����ѧ������
		List<Video> videoList=new ArrayList<Video>();
		
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // ��ȡ���ݿ�����
			
			// ��ȡ�ܼ�¼��
			List<Map<String, Object>> countResult = jdbcUtil.findResult(countSql.toString(), paramList);
			Map<String, Object> countMap = countResult.get(0);
			int totalRecord = ((Number)countMap.get("totalRecord")).intValue();
			
			// ��ȡ��ѯ��ѧ����¼
			List<Map<String, Object>> videoResult = jdbcUtil.findResult(sql.toString(), paramList);
			if (videoResult != null) {
				for (Map<String, Object> map : videoResult) {
					Video v=new Video(map);
					videoList.add(v);
					
				}
			}
			
			//��ȡ��ҳ��
			int totalPage = totalRecord / pageSize;
			if(totalRecord % pageSize !=0){
				totalPage++;
			}
			
			// ��װpager����
			
			result = new Pager<Video>(pageSize, pageNum, 
							totalRecord, totalPage, videoList);
			
		} catch (SQLException e) {
			throw new RuntimeException("��ѯ���������쳣��", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // һ��Ҫ�ͷ���Դ
			}
		}
		return result;
	}

}
