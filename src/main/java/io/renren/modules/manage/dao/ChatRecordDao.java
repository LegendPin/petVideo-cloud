package io.renren.modules.manage.dao;

import io.renren.modules.manage.entity.ChatRecordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 聊天记录表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-03-04 16:28:47
 */
@Mapper
public interface ChatRecordDao extends BaseMapper<ChatRecordEntity> {

}
