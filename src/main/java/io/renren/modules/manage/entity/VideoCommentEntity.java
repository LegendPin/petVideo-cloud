package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 视频评论表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
@TableName("t_video_comment")
public class VideoCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键自增
	 */
	@TableId
	private Integer id;
	/**
	 * 归属视频id
	 */
	private Integer videoId;
	/**
	 * 评论用户id
	 */
	private Integer commentUser;
	/**
	 * 评论用户姓名
	 */
	private String commentName;
	/**
	 * 评论人头像
	 */
	private String commentPic;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：主键自增
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键自增
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：归属视频id
	 */
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	/**
	 * 获取：归属视频id
	 */
	public Integer getVideoId() {
		return videoId;
	}
	/**
	 * 设置：评论用户id
	 */
	public void setCommentUser(Integer commentUser) {
		this.commentUser = commentUser;
	}
	/**
	 * 获取：评论用户id
	 */
	public Integer getCommentUser() {
		return commentUser;
	}
	/**
	 * 设置：评论用户姓名
	 */
	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}
	/**
	 * 获取：评论用户姓名
	 */
	public String getCommentName() {
		return commentName;
	}
	/**
	 * 设置：评论人头像
	 */
	public void setCommentPic(String commentPic) {
		this.commentPic = commentPic;
	}
	/**
	 * 获取：评论人头像
	 */
	public String getCommentPic() {
		return commentPic;
	}
	/**
	 * 设置：评论内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：评论内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
