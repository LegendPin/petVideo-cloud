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

import io.renren.modules.manage.entity.PetCommentEntity;
import io.renren.modules.manage.service.PetCommentService;
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
public class PetCommentController {
    @Autowired
    private PetCommentService petCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:pecomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = petCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("manage:pecomment:info")
    public R info(@PathVariable("id") Integer id){
			PetCommentEntity pecomment = petCommentService.selectById(id);

        return R.ok().put("pecomment", pecomment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:pecomment:save")
    public R save(@RequestBody PetCommentEntity pecomment){
			petCommentService.insert(pecomment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:pecomment:update")
    public R update(@RequestBody PetCommentEntity pecomment){
			petCommentService.updateById(pecomment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:pecomment:delete")
    public R delete(@RequestBody Integer[] ids){
			petCommentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
