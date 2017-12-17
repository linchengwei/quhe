package service;

import pager.Pager;
import pager.Video;
import dao.JdbcSqlVideoDaoImpl;
import dao.VideoDao;

public class JdbcSqlVideoServiceImpl implements VideoService {

	private VideoDao videoDao;
	public JdbcSqlVideoServiceImpl(){
		videoDao=new JdbcSqlVideoDaoImpl();
	}
	@Override
	public Pager<Video> findVideo(Video searchModel, int pageNum, int pageSize) {

		Pager<Video> result=videoDao.findVideo(searchModel, pageNum, pageSize);
		
		return result;
	}

}
