package io.renren.modules.manage.controller;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.common.exception.RRException;
import io.renren.common.utils.UploadUtils;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.manage.entity.VideoInfoEntity;
import io.renren.modules.manage.service.VideoInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
@RestController
@RequestMapping("manage/videoinfo")
public class VideoInfoController extends AbstractController {
    @Autowired
    private VideoInfoService videoInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:videoinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = videoInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
			VideoInfoEntity videoInfo = videoInfoService.selectById(id);

        return R.ok().put("videoInfo", videoInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody VideoInfoEntity videoInfo){
        //设置宠物id
        videoInfo.setPetId(getUserId().intValue());
        videoInfo.setCreateTime(new Date());
        videoInfoService.insert(videoInfo);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:videoinfo:update")
    public R update(@RequestBody VideoInfoEntity videoInfo){
			videoInfoService.updateById(videoInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:videoinfo:delete")
    public R delete(@RequestBody Integer[] ids){
			videoInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 上传视频截图
     * @author LuJie
     * @param file
     * @return
     */
    @PostMapping("/uploadHead")
    public R uploadHead(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty() || file.getOriginalFilename() == null || file.getSize() == 0
                || file.getSize() > 3*1024*1024) {
            return R.error(901, "文件不存在或参数异常");
        }
        //获取新的文件名
        String filename = file.getOriginalFilename();
        //保存文件并获取新的文件地址
        String fileUrl = UploadUtils.saveFile("/upload/", "headpic", file);
        if (fileUrl == null || filename == null || fileUrl.equals("") || filename.equals("")) {
            throw new RRException("文件保存失败", 500);
        }

        return R.ok().put("fileUrl", fileUrl);
    }

    /**
     * 上传视频
     * @author LuJie
     * @param file
     * @return
     */
    @PostMapping("/uploadVideo")
    public R uploadVideo(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty() || file.getOriginalFilename() == null || file.getSize() == 0
                || file.getSize() > 1000*1024*1024) {
            return R.error(901, "文件不存在或参数异常");
        }
        //获取新的文件名
        String filename = file.getOriginalFilename();
        //保存文件并获取新的文件地址
        String fileUrl = UploadUtils.saveFile("/upload/", "video", file);
        if (fileUrl == null || filename == null || fileUrl.equals("") || filename.equals("")) {
            throw new RRException("文件保存失败", 500);
        }

        R ret = R.ok();
        ret.put("filename", filename);
        ret.put("fileUrl", fileUrl);
        return ret;
    }

    @GetMapping("/getVideoList")
    public R getVideoList(VideoInfoEntity video){
        return R.ok().put("page", videoInfoService.getVideoList(video));
    }

}
