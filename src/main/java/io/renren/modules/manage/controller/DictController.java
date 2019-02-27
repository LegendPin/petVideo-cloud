package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.Map;

import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.manage.entity.DictEntity;
import io.renren.modules.manage.service.DictService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 字典表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-02-27 11:03:05
 */
@RestController
@RequestMapping("manage/dict")
public class DictController {
    @Autowired
    private DictService dictService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dictService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
			DictEntity dict = dictService.selectById(id);

        return R.ok().put("dict", dict);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DictEntity dict){
			dictService.insert(dict);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DictEntity dict){
			dictService.updateById(dict);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
			dictService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 根据字典码获取字典列表
     * @param: [ids]
     * @return: io.renren.common.utils.R
     * @author: LuJie
     * @date: 2019/2/27
     **/
    @RequestMapping("/getDictListByParent")
    public R getDictListByParent(@RequestParam("code") Integer code){
        return R.ok().put("list", dictService.selectList(new EntityWrapper<DictEntity>().eq("parent", code)));
    }

}
