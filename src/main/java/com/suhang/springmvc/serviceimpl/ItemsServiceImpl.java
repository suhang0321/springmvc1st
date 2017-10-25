package com.suhang.springmvc.serviceimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.suhang.springmvc.exception.CustomException;
import com.suhang.springmvc.exception.CustomException;
import com.suhang.springmvc.mapper.ItemsMapper;
import com.suhang.springmvc.po.Items;
import com.suhang.springmvc.po.ItemsCustomer;
import com.suhang.springmvc.po.ItemsCustomerVo;
import com.suhang.springmvc.serivice.ItemsService;

/**
 * @author hang.su
 * @since 2017-09-28 15:31
 */
@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustomer> findItemsList(ItemsCustomerVo itemsCustomerVo) throws Exception {
        return itemsMapper.findItemsList(itemsCustomerVo);
    }

    @Override
    public ItemsCustomer findItemsById(Integer id) throws Exception {
        ItemsCustomer itemsCustomer = itemsMapper.findItemsById(id);
        if (itemsCustomer==null){
           throw new CustomException("所要修改的商品信息不存在");
        }
        return itemsCustomer;
    }

    @Override
    public void updateItems(Integer id, ItemsCustomer itemsCustomer) throws Exception {
        Items items = new Items();
        items.setId(id);
        BeanUtils.copyProperties(itemsCustomer,items);
        BeanUtils.copyProperties(items,itemsCustomer);
        itemsMapper.updateItems(itemsCustomer);
    }

    @Override
    public void deleteItems(Integer[] ids) throws Exception {
        itemsMapper.deleteItems(ids);
    }

    @Override
    public void updateItemsList(List<ItemsCustomer> itemsCustomerList) throws Exception {
        itemsMapper.updateItemsList(itemsCustomerList);
    }


}
