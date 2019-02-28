package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.manage.entity.PetInfoEntity;
import io.renren.modules.manage.service.PetInfoService;
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
@RequestMapping("manage/petInfo")
public class PetInfoController extends AbstractController {
    @Autowired
    private PetInfoService petInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = petInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
			PetInfoEntity petInfo = petInfoService.selectById(id);

        return R.ok().put("info", petInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PetInfoEntity peinfo){
			petInfoService.insert(peinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PetInfoEntity petInfo){
        petInfoService.updateById(petInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:peinfo:delete")
    public R delete(@RequestBody Integer[] ids){
			petInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 获取当前用户的宠物信息
     * @author: LuJie
     **/
    @RequestMapping("/info")
    public R info(){
        PetInfoEntity petInfo = petInfoService.selectOne(new EntityWrapper<PetInfoEntity>().eq("user_id", getUserId().intValue()));

        return R.ok().put("info", petInfo);
    }

}
