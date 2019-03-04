package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 聊天关系表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-03-04 16:28:47
 */
@TableName("t_pet_chat")
public class PetChatEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 宠物一id
	 */
	private Integer onePet;
	/**
	 * 宠物二id
	 */
	private Integer secondPet;
	/**
	 * 1:未使用，2:使用
	 */
	private Integer isUsed;
	/**
	 * 更新时间
	 */
	private Date updateTime;

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
	 * 设置：宠物一id
	 */
	public void setOnePet(Integer onePet) {
		this.onePet = onePet;
	}
	/**
	 * 获取：宠物一id
	 */
	public Integer getOnePet() {
		return onePet;
	}
	/**
	 * 设置：宠物二id
	 */
	public void setSecondPet(Integer secondPet) {
		this.secondPet = secondPet;
	}
	/**
	 * 获取：宠物二id
	 */
	public Integer getSecondPet() {
		return secondPet;
	}
	/**
	 * 设置：1:未使用，2:使用
	 */
	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}
	/**
	 * 获取：1:未使用，2:使用
	 */
	public Integer getIsUsed() {
		return isUsed;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
