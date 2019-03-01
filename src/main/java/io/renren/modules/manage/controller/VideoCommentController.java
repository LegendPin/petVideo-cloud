package io.renren.modules.manage.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.manage.entity.PetInfoEntity;
import io.renren.modules.manage.entity.VideoCommentEntity;
import io.renren.modules.manage.service.PetInfoService;
import io.renren.modules.manage.service.VideoCommentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import static io.renren.common.utils.ShiroUtils.getUserId;


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
    @Autowired
    private PetInfoService petInfoService;


    /**
     * 列表
     */
    @RequestMapping("/list")
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

    /**
     * 提交评论
     */
    @RequestMapping("/submitComment")
    public R submitComment(@RequestBody VideoCommentEntity videoComment){
        //获取当前登录用户信息
        PetInfoEntity petInfo = petInfoService.selectOne(new EntityWrapper<PetInfoEntity>().eq("user_id", getUserId().intValue()));
        if (petInfo == null){
            return R.error(901, "未登录");
        }
        videoComment.setCommentUser(petInfo.getId());
        videoComment.setCommentName(petInfo.getName());
        videoComment.setCommentPic(petInfo.getHeadPic());
        videoComment.setCreateTime(new Date());
        videoCommentService.insert(videoComment);
        return R.ok();
    }
}
