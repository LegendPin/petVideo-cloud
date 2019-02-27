package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.manage.entity.VideoCommentEntity;
import io.renren.modules.manage.service.VideoCommentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 视频评论表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
@RestController
@RequestMapping("manage/videocomment")
public class VideoCommentController {
    @Autowired
    private VideoCommentService videoCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:videocomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = videoCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("manage:videocomment:info")
    public R info(@PathVariable("id") Integer id){
			VideoCommentEntity videoComment = videoCommentService.selectById(id);

        return R.ok().put("videoComment", videoComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:videocomment:save")
    public R save(@RequestBody VideoCommentEntity videoComment){
			videoCommentService.insert(videoComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:videocomment:update")
    public R update(@RequestBody VideoCommentEntity videoComment){
			videoCommentService.updateById(videoComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:videocomment:delete")
    public R delete(@RequestBody Integer[] ids){
			videoCommentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
