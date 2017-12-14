package dao;

import pager.Pager;
import pager.Video;

public interface VideoDao {

	/**
	 * 根据视频的查询条件，来查询视频的分页信息
	 * @param searchModel 封装查询信息
	 * @param pageNum 查询第几页数据
	 * @param pageSize 每页显示多少条记录
	 * @return 返回查询结果
	 */
	public Pager<Video> findVideo(Video searchModel, int pageNum,
		int pageSize);
}
