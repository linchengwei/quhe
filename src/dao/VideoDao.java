package dao;

import pager.Pager;
import pager.Video;

public interface VideoDao {

	/**
	 * ������Ƶ�Ĳ�ѯ����������ѯ��Ƶ�ķ�ҳ��Ϣ
	 * @param searchModel ��װ��ѯ��Ϣ
	 * @param pageNum ��ѯ�ڼ�ҳ����
	 * @param pageSize ÿҳ��ʾ��������¼
	 * @return ���ز�ѯ���
	 */
	public Pager<Video> findVideo(Video searchModel, int pageNum,
		int pageSize);
}
