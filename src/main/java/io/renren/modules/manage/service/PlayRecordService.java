package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.PlayRecordEntity;

import java.util.Map;

/**
 * 播放记录表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-03-10 15:57:41
 */
public interface PlayRecordService extends IService<PlayRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

