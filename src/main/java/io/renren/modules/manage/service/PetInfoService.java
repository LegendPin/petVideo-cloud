package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.PetInfoEntity;

import java.util.Map;

/**
 * 宠物信息表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
public interface PetInfoService extends IService<PetInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

