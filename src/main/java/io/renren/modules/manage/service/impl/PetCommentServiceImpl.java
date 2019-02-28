package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.PetCommentDao;
import io.renren.modules.manage.entity.PetCommentEntity;
import io.renren.modules.manage.service.PetCommentService;


@Service("petCommentService")
public class PetCommentServiceImpl extends ServiceImpl<PetCommentDao, PetCommentEntity> implements PetCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PetCommentEntity> page = this.selectPage(
                new Query<PetCommentEntity>(params).getPage(),
                new EntityWrapper<PetCommentEntity>()
        );

        return new PageUtils(page);
    }

}
