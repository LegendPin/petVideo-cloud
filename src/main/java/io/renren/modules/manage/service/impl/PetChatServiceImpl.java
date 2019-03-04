package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.PetChatDao;
import io.renren.modules.manage.entity.PetChatEntity;
import io.renren.modules.manage.service.PetChatService;


@Service("pechatService")
public class PetChatServiceImpl extends ServiceImpl<PetChatDao, PetChatEntity> implements PetChatService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PetChatEntity> page = this.selectPage(
                new Query<PetChatEntity>(params).getPage(),
                new EntityWrapper<PetChatEntity>()
        );

        return new PageUtils(page);
    }

}
