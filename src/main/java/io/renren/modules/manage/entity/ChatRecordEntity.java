package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 聊天记录表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-03-04 16:28:47
 */
@TableName("t_chat_record")
public class ChatRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 聊天组id
	 */
	private Integer chatId;
	/**
	 * 发送方
	 */
	private String sendUser;
	/**
	 * 发送内容
	 */
	private String content;
	/**
	 * 消息时间
	 */
	private Date createTime;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：聊天组id
	 */
	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}
	/**
	 * 获取：聊天组id
	 */
	public Integer getChatId() {
		return chatId;
	}
	/**
	 * 设置：发送方
	 */
	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}
	/**
	 * 获取：发送方
	 */
	public String getSendUser() {
		return sendUser;
	}
	/**
	 * 设置：发送内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：发送内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：消息时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：消息时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
