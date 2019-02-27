package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 *
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
@TableName("t_video_info")
public class VideoInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键，自增
	 */
	@TableId
	private Integer id;
	/**
	 * 归属宠物id
	 */
	private Integer petId;
	/**
	 * 视频名称
	 */
	private String name;
	/**
	 * 视频分类，字典码
	 */
	private Integer type;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件地址
	 */
	private String fileUrl;
	/**
	 * 文件类型
	 */
	private String fileType;
	/**
	 * 文件大小
	 */
	private Long fileSize;
	/**
	 * 文件介绍
	 */
	private String remark;
	/**
	 * 视频截图
	 */
	private String filePic;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 视频时长
	 */
	private Time videoLength;

	/**
	 * 设置：主键，自增
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键，自增
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：归属宠物id
	 */
	public void setPetId(Integer petId) {
		this.petId = petId;
	}
	/**
	 * 获取：归属宠物id
	 */
	public Integer getPetId() {
		return petId;
	}
	/**
	 * 设置：视频名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：视频名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：视频分类，字典码
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：视频分类，字典码
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：文件名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名称
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：文件地址
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	/**
	 * 获取：文件地址
	 */
	public String getFileUrl() {
		return fileUrl;
	}
	/**
	 * 设置：文件类型
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：文件类型
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * 设置：文件大小
	 */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	/**
	 * 获取：文件大小
	 */
	public Long getFileSize() {
		return fileSize;
	}
	/**
	 * 设置：文件介绍
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：文件介绍
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：视频截图
	 */
	public void setFilePic(String filePic) {
		this.filePic = filePic;
	}
	/**
	 * 获取：视频截图
	 */
	public String getFilePic() {
		return filePic;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：视频时长
	 */
	public void setVideoLength(Time videoLength) {
		this.videoLength = videoLength;
	}
	/**
	 * 获取：视频时长
	 */
	public Time getVideoLength() {
		return videoLength;
	}
}
