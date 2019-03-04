package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.List;
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

import io.renren.modules.manage.entity.PetChatEntity;
import io.renren.modules.manage.service.PetChatService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 聊天关系表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-03-04 16:28:47
 */
@RestController
@RequestMapping("manage/petChat")
public class PetChatController extends AbstractController {
    @Autowired
    private PetChatService petChatService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = petChatService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        PetChatEntity pechat = petChatService.selectById(id);

        return R.ok().put("pechat", pechat);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PetChatEntity pechat){
        petChatService.insert(pechat);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PetChatEntity pechat){
        petChatService.updateById(pechat);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        petChatService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 创建聊天关系
     * @author: LuJie
     * @date: 2019/3/1
     **/
    @RequestMapping("/createChatRelation")
    public R createChatRelation(@RequestParam("userOne") Integer userOne, @RequestParam("userTwo") Integer userTwo){
        if (userOne == null || userTwo == null){
            return R.error("id无效");
        }
        petChatService.createChatRelation(userOne, userTwo);
        return R.ok();
    }


    /**
     * 查询当前用户的聊天列表
     * @author: LuJie
     * @date: 2019/3/1
     **/
    @RequestMapping("/getChatUserList")
    public R getChatUserList(@RequestParam("id") Integer id){
        List<PetChatEntity> chatList = petChatService.getChatUserList(id);
        return R.ok().put("list", chatList);
    }
}
