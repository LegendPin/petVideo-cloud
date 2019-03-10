package io.renren.modules.manage.controller;

import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.manage.entity.VideoInfoEntity;
import io.renren.modules.manage.service.VideoInfoService;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.manage.entity.PlayRecordEntity;
import io.renren.modules.manage.service.PlayRecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import sun.security.util.Length;


/**
 * 播放记录表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-03-10 15:57:41
 */
@RestController
@RequestMapping("manage/playrecord")
public class PlayRecordController extends AbstractController {
    @Autowired
    private PlayRecordService playRecordService;
    @Autowired
    private VideoInfoService videoInfoService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = playRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        PlayRecordEntity playRecord = playRecordService.selectById(id);

        return R.ok().put("playRecord", playRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PlayRecordEntity playRecord){

        //获取对应的视频信息
        VideoInfoEntity video = videoInfoService.selectById(playRecord.getVideoId());
        playRecord.setName(video.getName());
        playRecord.setCreateTime(new Date());
        playRecord.setUserId(getUserId().intValue());
        playRecordService.insert(playRecord);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PlayRecordEntity playRecord){
        playRecordService.updateById(playRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        playRecordService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 获取用户播放记录，最新5条
     * @author LuJie
     * @return
     */
    @GetMapping("/getRecordsLimit")
    public R getRecordsLimit(){

        List<PlayRecordEntity> rlist =  playRecordService.selectList(new EntityWrapper<PlayRecordEntity>()
                .eq("user_id", getUserId().intValue())
                .orderBy("create_time", false));
        //获取最新的5条
        int length = rlist.size() > 5? 5:rlist.size();
        List<PlayRecordEntity> tList = new ArrayList<>();
        for (int i=0;i<length; i++) {
            tList.add(rlist.get(i));
        }


        return R.ok().put("list", tList);
    }

}
