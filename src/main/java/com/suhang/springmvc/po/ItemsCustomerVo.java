package com.suhang.springmvc.po;

import java.util.List;

/**
 * @author hang.su
 * @since 2017-09-28 15:04
 */
public class ItemsCustomerVo {

    private ItemsCustomer itemsCustomer;

    private Items items;

    private List<ItemsCustomer> itemsList;

    public void setItemsList(List<ItemsCustomer> itemsList) {
        this.itemsList = itemsList;
    }

    public List<ItemsCustomer> getItemsList() {

        return itemsList;
    }

    public ItemsCustomer getItemsCustomer() {
        return itemsCustomer;
    }

    public Items getItems() {
        return items;
    }

    public void setItemsCustomer(ItemsCustomer itemsCustomer) {
        this.itemsCustomer = itemsCustomer;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
