package io.renren.modules.manage.dao;

import com.baomidou.mybatisplus.plugins.Page;
import io.renren.modules.manage.entity.VideoInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
@Mapper
public interface VideoInfoDao extends BaseMapper<VideoInfoEntity> {

    List<VideoInfoEntity> getVideoList(Page<VideoInfoEntity> page, VideoInfoEntity info);
}
