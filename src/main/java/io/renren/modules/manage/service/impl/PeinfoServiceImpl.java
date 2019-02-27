package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.PeinfoDao;
import io.renren.modules.manage.entity.PeinfoEntity;
import io.renren.modules.manage.service.PeinfoService;


@Service("peinfoService")
public class PeinfoServiceImpl extends ServiceImpl<PeinfoDao, PeinfoEntity> implements PeinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeinfoEntity> page = this.selectPage(
                new Query<PeinfoEntity>(params).getPage(),
                new EntityWrapper<PeinfoEntity>()
        );

        return new PageUtils(page);
    }

}
