package pager;

import java.io.Serializable;
import java.sql.Timestamp;

import java.util.Map;

public class Video implements Serializable {

	private static final long serialVersionUID = 4033571319570667008L;

	private int video_id;
	private String user_id;
	private String video_name;
	private String video_img;
	private String video_address;
	private Timestamp release_time;
	private int check_status;
	
	
	public Video() {
		super();
	}
	public Video(Map<String, Object> map){
		this.video_id=(Integer)map.get("video_id");
		
		this.user_id=(String)map.get("user_id");
		this.video_name=(String)map.get("video_name");
		this.video_img=(String)map.get("video_img");
		this.video_address=(String)map.get("video_address"); 
		this.release_time=(Timestamp)map.get("release_time");
		this.check_status=(Integer)map.get("check_status");
	}
	
	public Video(int video_id, String user_id, String video_name,
			String video_img, String video_address, Timestamp release_time,
			int check_status) {
		super();
		this.video_id = video_id;
		this.user_id = user_id;
		this.video_name = video_name;
		this.video_img = video_img;
		this.video_address = video_address;
		this.release_time = release_time;
		this.check_status = check_status;
	}
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public String getVideo_img() {
		return video_img;
	}
	public void setVideo_img(String video_img) {
		this.video_img = video_img;
	}
	public String getVideo_address() {
		return video_address;
	}
	public void setVideo_address(String video_address) {
		this.video_address = video_address;
	}
	public Timestamp getRelease_time() {
		return release_time;
	}
	public void setRelease_time(Timestamp release_time) {
		this.release_time = release_time;
	}
	public int getCheck_status() {
		return check_status;
	}
	public void setCheck_status(int check_status) {
		this.check_status = check_status;
	}
	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", user_id=" + user_id
				+ ", video_name=" + video_name + ", video_img=" + video_img
				+ ", video_address=" + video_address + ", release_time="
				+ release_time + ", check_status=" + check_status + "]";
	}
	
	
}
