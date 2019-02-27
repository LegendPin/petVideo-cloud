package io.renren.modules.manage.dao;

import io.renren.modules.manage.entity.PecommentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 宠物留言表
 * 
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
@Mapper
public interface PecommentDao extends BaseMapper<PecommentEntity> {
	
}
