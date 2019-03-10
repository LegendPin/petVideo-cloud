package io.renren.modules.manage.dao;

import io.renren.modules.manage.entity.PlayRecordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 播放记录表
 * 
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-03-10 15:57:41
 */
@Mapper
public interface PlayRecordDao extends BaseMapper<PlayRecordEntity> {
	
}
