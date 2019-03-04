package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ChatRecordDao;
import io.renren.modules.manage.entity.ChatRecordEntity;
import io.renren.modules.manage.service.ChatRecordService;


@Service("charecordService")
public class ChatRecordServiceImpl extends ServiceImpl<ChatRecordDao, ChatRecordEntity> implements ChatRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChatRecordEntity> page = this.selectPage(
                new Query<ChatRecordEntity>(params).getPage(),
                new EntityWrapper<ChatRecordEntity>()
        );

        return new PageUtils(page);
    }

}
