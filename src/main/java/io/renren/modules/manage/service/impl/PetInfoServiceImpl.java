package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.PetInfoDao;
import io.renren.modules.manage.entity.PetInfoEntity;
import io.renren.modules.manage.service.PetInfoService;


@Service("petInfoService")
public class PetInfoServiceImpl extends ServiceImpl<PetInfoDao, PetInfoEntity> implements PetInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PetInfoEntity> page = this.selectPage(
                new Query<PetInfoEntity>(params).getPage(),
                new EntityWrapper<PetInfoEntity>()
        );

        return new PageUtils(page);
    }

}
