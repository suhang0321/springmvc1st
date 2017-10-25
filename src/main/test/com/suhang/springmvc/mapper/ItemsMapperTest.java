package com.suhang.springmvc.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suhang.springmvc.po.Items;
import com.suhang.springmvc.po.ItemsCustomer;
import com.suhang.springmvc.po.ItemsCustomerVo;

/**
 * @author hang.su
 * @since 2017-09-29 10:46
 */
public class ItemsMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {

        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

    @Test
    public void findItemsListTest() throws Exception {
        ItemsMapper itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");


        List<ItemsCustomer> itemslist = itemsMapper.findItemsList(null);
    }

    @Test
    public void updateItemTest() throws Exception {
        ItemsMapper itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
        ItemsCustomer itemsCustomer = new ItemsCustomer();
        itemsCustomer.setId(1);
        itemsCustomer.setName("hasee");
        itemsCustomer.setPrice(3666);
        itemsCustomer.setDetail("游戏本");
        itemsMapper.updateItems(itemsCustomer);
    }

    @Test
    public void deleteItemsTest() throws Exception {
        ItemsMapper itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
        Integer[] ids = {4, 5};
        itemsMapper.deleteItems(ids);
    }

    @Test
    public void updateItemsListTest() throws Exception {
        ItemsMapper itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
        List<ItemsCustomer> itemsCustomers =new ArrayList<>();
        ItemsCustomer itemsCustomer1 = new ItemsCustomer();
        ItemsCustomer itemsCustomer2 = new ItemsCustomer();
        itemsCustomer1.setId(1);
        itemsCustomer1.setName("pro");
        itemsCustomer1.setPrice(9999);
        itemsCustomer1.setDetail("mac");
        itemsCustomer2.setId(2);
        itemsCustomer2.setName("air");
        itemsCustomer2.setPrice(8888);
        itemsCustomer2.setDetail("mac");
        itemsCustomers.add(itemsCustomer1);
        itemsCustomers.add(itemsCustomer2);
        itemsMapper.updateItemsList(itemsCustomers);
    }
}
