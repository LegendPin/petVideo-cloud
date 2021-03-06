package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.VideoInfoDao;
import io.renren.modules.manage.entity.VideoInfoEntity;
import io.renren.modules.manage.service.VideoInfoService;


@Service("videoInfoService")
public class VideoInfoServiceImpl extends ServiceImpl<VideoInfoDao, VideoInfoEntity> implements VideoInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<VideoInfoEntity> page = this.selectPage(
                new Query<VideoInfoEntity>(params).getPage(),
                new EntityWrapper<VideoInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Page<VideoInfoEntity> getVideoList(VideoInfoEntity info) {
        Page<VideoInfoEntity> page = new Page<>(info.getCurrent(), info.getSize());
        List<VideoInfoEntity> rList = this.baseMapper.getVideoList(page, info);
        return page.setRecords(rList);
    }

}
