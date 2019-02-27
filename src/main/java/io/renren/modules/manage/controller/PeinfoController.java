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

import io.renren.modules.manage.entity.PeinfoEntity;
import io.renren.modules.manage.service.PeinfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 宠物信息表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
@RestController
@RequestMapping("manage/peinfo")
public class PeinfoController {
    @Autowired
    private PeinfoService peinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:peinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = peinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("manage:peinfo:info")
    public R info(@PathVariable("id") Integer id){
			PeinfoEntity peinfo = peinfoService.selectById(id);

        return R.ok().put("peinfo", peinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:peinfo:save")
    public R save(@RequestBody PeinfoEntity peinfo){
			peinfoService.insert(peinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:peinfo:update")
    public R update(@RequestBody PeinfoEntity peinfo){
			peinfoService.updateById(peinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:peinfo:delete")
    public R delete(@RequestBody Integer[] ids){
			peinfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
