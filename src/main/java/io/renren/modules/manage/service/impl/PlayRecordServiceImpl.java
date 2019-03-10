package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.PlayRecordDao;
import io.renren.modules.manage.entity.PlayRecordEntity;
import io.renren.modules.manage.service.PlayRecordService;


@Service("playRecordService")
public class PlayRecordServiceImpl extends ServiceImpl<PlayRecordDao, PlayRecordEntity> implements PlayRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PlayRecordEntity> page = this.selectPage(
                new Query<PlayRecordEntity>(params).getPage(),
                new EntityWrapper<PlayRecordEntity>()
        );

        return new PageUtils(page);
    }

}
