package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.VideoCommentDao;
import io.renren.modules.manage.entity.VideoCommentEntity;
import io.renren.modules.manage.service.VideoCommentService;


@Service("videoCommentService")
public class VideoCommentServiceImpl extends ServiceImpl<VideoCommentDao, VideoCommentEntity> implements VideoCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<VideoCommentEntity> page = this.selectPage(
                new Query<VideoCommentEntity>(params).getPage(),
                new EntityWrapper<VideoCommentEntity>()
        );

        return new PageUtils(page);
    }

}
