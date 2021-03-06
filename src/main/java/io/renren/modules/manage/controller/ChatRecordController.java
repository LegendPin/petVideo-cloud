package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.manage.entity.ChatRecordEntity;
import io.renren.modules.manage.service.ChatRecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 聊天记录表
 *
 * @author LuJie
 * @email 691539368@gmail.com
 * @date 2019-03-04 16:28:47
 */
@RestController
@RequestMapping("manage/chatRecord")
public class ChatRecordController {
    @Autowired
    private ChatRecordService chatRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = chatRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        ChatRecordEntity charecord = chatRecordService.selectById(id);

        return R.ok().put("charecord", charecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChatRecordEntity chatRecord){
        chatRecord.setCreateTime(new Date());
        chatRecordService.insert(chatRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChatRecordEntity charecord){
        chatRecordService.updateById(charecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        chatRecordService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 查询对应聊天关系表的聊天记录
     * @author: LuJie
     * @date: 2019/3/1
     **/
    @RequestMapping("/getChatRecordList")
    public R getChatRecordList(@RequestParam("id") Integer id){
        List<ChatRecordEntity> chatList = chatRecordService.selectList(
                new EntityWrapper<ChatRecordEntity>()
                        .eq("chat_id", id).orderBy("id", true));
        return R.ok().put("list", chatList);
    }

}
