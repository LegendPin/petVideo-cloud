package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.VideoInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
public interface VideoInfoService extends IService<VideoInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Page<VideoInfoEntity> getVideoList(VideoInfoEntity info);
}

