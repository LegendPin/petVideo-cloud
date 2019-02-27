package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.PecommentDao;
import io.renren.modules.manage.entity.PecommentEntity;
import io.renren.modules.manage.service.PecommentService;


@Service("pecommentService")
public class PecommentServiceImpl extends ServiceImpl<PecommentDao, PecommentEntity> implements PecommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PecommentEntity> page = this.selectPage(
                new Query<PecommentEntity>(params).getPage(),
                new EntityWrapper<PecommentEntity>()
        );

        return new PageUtils(page);
    }

}
