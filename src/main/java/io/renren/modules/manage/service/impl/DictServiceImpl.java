package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.DictDao;
import io.renren.modules.manage.entity.DictEntity;
import io.renren.modules.manage.service.DictService;


@Service("dictService")
public class DictServiceImpl extends ServiceImpl<DictDao, DictEntity> implements DictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DictEntity> page = this.selectPage(
                new Query<DictEntity>(params).getPage(),
                new EntityWrapper<DictEntity>()
        );

        return new PageUtils(page);
    }

}
