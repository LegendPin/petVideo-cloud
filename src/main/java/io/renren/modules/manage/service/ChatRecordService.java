package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ChatRecordEntity;

import java.util.Map;

/**
 * 聊天记录表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-03-04 16:28:47
 */
public interface ChatRecordService extends IService<ChatRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

