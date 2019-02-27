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

import io.renren.modules.manage.entity.PecommentEntity;
import io.renren.modules.manage.service.PecommentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 宠物留言表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
@RestController
@RequestMapping("manage/pecomment")
public class PecommentController {
    @Autowired
    private PecommentService pecommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:pecomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pecommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("manage:pecomment:info")
    public R info(@PathVariable("id") Integer id){
			PecommentEntity pecomment = pecommentService.selectById(id);

        return R.ok().put("pecomment", pecomment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:pecomment:save")
    public R save(@RequestBody PecommentEntity pecomment){
			pecommentService.insert(pecomment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:pecomment:update")
    public R update(@RequestBody PecommentEntity pecomment){
			pecommentService.updateById(pecomment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:pecomment:delete")
    public R delete(@RequestBody Integer[] ids){
			pecommentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
