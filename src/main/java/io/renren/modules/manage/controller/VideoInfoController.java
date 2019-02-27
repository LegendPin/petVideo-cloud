package io.renren.modules.manage.controller;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;

import io.renren.common.exception.RRException;
import io.renren.common.utils.UploadUtils;
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
public class VideoInfoController {
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
    @RequiresPermissions("manage:videoinfo:info")
    public R info(@PathVariable("id") Integer id){
			VideoInfoEntity videoInfo = videoInfoService.selectById(id);

        return R.ok().put("videoInfo", videoInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:videoinfo:save")
    public R save(@RequestBody VideoInfoEntity videoInfo){
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


    @PostMapping("/uploadHead")
    public R uploadHead(@RequestParam(value = "file") MultipartFile file) throws FileNotFoundException {
        if (file.isEmpty() || file.getOriginalFilename() == null || file.getSize() == 0
                || file.getSize() > 3*1024*1024) {
            return R.error(901, "文件不存在或参数异常");
        }
        //获取新的文件名
        String filename = file.getOriginalFilename();
        //String fileUrl = "static/headpic/";
        String url = ResourceUtils.getURL("classpath:").getPath()+"static";
        //保存文件并获取新的文件地址
        String fileUrl = UploadUtils.saveFile("/petfile", "headpic", file);
        if (fileUrl == null || filename == null || fileUrl.equals("") || filename.equals("")) {
            throw new RRException("文件保存失败", 500);
        }

        return R.ok().put("fileUrl", fileUrl);
    }

}
