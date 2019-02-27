package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 宠物信息表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
@TableName("t_pet_info")
public class PeinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键，自增
	 */
	@TableId
	private Integer id;
	/**
	 * 关联账号id
	 */
	private Integer userId;
	/**
	 * 宠物名称
	 */
	private String name;
	/**
	 * 头像文件路径
	 */
	private String headPic;
	/**
	 * 性别(0:男 1：女 2：不限)
	 */
	private Integer sex;
	/**
	 * 种类，字典码
	 */
	private Integer type;
	/**
	 * 出生日期
	 */
	private Date birthday;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 个人介绍
	 */
	private String remark;
	/**
	 * 铲屎官姓名
	 */
	private String owner;
	/**
	 * 创建时间
	 */
	private Date createTime;

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
	 * 设置：关联账号id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：关联账号id
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：宠物名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：宠物名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：头像文件路径
	 */
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	/**
	 * 获取：头像文件路径
	 */
	public String getHeadPic() {
		return headPic;
	}
	/**
	 * 设置：性别(0:男 1：女 2：不限)
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别(0:男 1：女 2：不限)
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：种类，字典码
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：种类，字典码
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：出生日期
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 设置：电话号码
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话号码
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：个人介绍
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：个人介绍
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：铲屎官姓名
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * 获取：铲屎官姓名
	 */
	public String getOwner() {
		return owner;
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
