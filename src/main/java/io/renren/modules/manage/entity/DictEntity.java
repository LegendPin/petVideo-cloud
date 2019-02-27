package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
@TableName("t_dict")
public class DictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId
	private Integer id;
	/**
	 * 关联父code
	 */
	private Integer parent;
	/**
	 * 字典码
	 */
	private Integer dictCode;
	/**
	 * 名称
	 */
	private String dictName;

	/**
	 * 设置：自增主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：自增主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：关联父code
	 */
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	/**
	 * 获取：关联父code
	 */
	public Integer getParent() {
		return parent;
	}
	/**
	 * 设置：字典码
	 */
	public void setDictCode(Integer dictCode) {
		this.dictCode = dictCode;
	}
	/**
	 * 获取：字典码
	 */
	public Integer getDictCode() {
		return dictCode;
	}
	/**
	 * 设置：名称
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	/**
	 * 获取：名称
	 */
	public String getDictName() {
		return dictName;
	}
}
