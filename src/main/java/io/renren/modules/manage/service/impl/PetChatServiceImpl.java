package io.renren.modules.manage.service.impl;

import io.renren.modules.manage.dao.PetInfoDao;
import io.renren.modules.manage.entity.PetInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.PetChatDao;
import io.renren.modules.manage.entity.PetChatEntity;
import io.renren.modules.manage.service.PetChatService;


@Service("pechatService")
public class PetChatServiceImpl extends ServiceImpl<PetChatDao, PetChatEntity> implements PetChatService {

    @Autowired
    private PetInfoDao petInfoDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PetChatEntity> page = this.selectPage(
                new Query<PetChatEntity>(params).getPage(),
                new EntityWrapper<PetChatEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 创建聊天关系
     * @author: LuJie
     * @date: 2019/3/1
     **/
    @Override
    public void createChatRelation(Integer userOne, Integer userTwo) {
        List<PetChatEntity> temp= this.baseMapper.judgeRelationExit(userOne, userTwo);
        //不存在关系，新建
        if (temp == null || temp.size() == 0){
            //获取两只宠物的信息
            PetInfoEntity petOne = petInfoDao.selectById(userOne);
            PetInfoEntity petTwo = petInfoDao.selectById(userTwo);
            //创建新的实体
            PetChatEntity node = new PetChatEntity();
            node.setOnePet(userOne);
            node.setOneName(petOne.getName());
            node.setOneHead(petOne.getHeadPic());
            node.setSecondPet(userTwo);
            node.setSecondName(petTwo.getName());
            node.setSecondHead(petTwo.getHeadPic());
            node.setIsUsed(1);
            node.setUpdateTime(new Date());
            this.baseMapper.insert(node);
        } else {
            //已存在，更新时间
            PetChatEntity node = temp.get(0);
            node.setUpdateTime(new Date());
            this.baseMapper.updateById(node);

        }
    }

    @Override
    public List<PetChatEntity> getChatUserList(Integer userId) {
        return this.baseMapper.getChatUserList(userId);
    }


}
