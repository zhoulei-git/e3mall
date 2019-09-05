package cn.e3mall.service.impl;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ray2hou
 * @create 2019-09-04-20:29
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public TbItem getItemById(long itemId) {
        TbItemExample tbItemExample=new TbItemExample();
        tbItemExample.createCriteria().andIdEqualTo(itemId);
        List<TbItem> list=tbItemMapper.selectByExample(tbItemExample);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
