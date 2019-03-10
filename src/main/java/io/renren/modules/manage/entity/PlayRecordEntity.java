package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 播放记录表
 * 
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-03-10 15:57:41
 */
@TableName("t_play_record")
public class PlayRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 视频id
	 */
	private Integer videoId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 记录归属用户id
	 */
	private Integer userId;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：视频id
	 */
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	/**
	 * 获取：视频id
	 */
	public Integer getVideoId() {
		return videoId;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：记录归属用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：记录归属用户id
	 */
	public Integer getUserId() {
		return userId;
	}
}
