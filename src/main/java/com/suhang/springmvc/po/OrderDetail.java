package com.suhang.springmvc.po;

/**
 * @author hang.su
 * @since 2017-09-23 16:21
 */
public class OrderDetail {
    public int id;
    public int orders_id;
    public int items_id;
    public int items_num;
    public Items items;
    public Orders orders;

    public int getId() {
        return id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public int getItems_id() {
        return items_id;
    }

    public int getItems_num() {
        return items_num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public void setItems_id(int items_id) {
        this.items_id = items_id;
    }

    public void setItems_num(int items_num) {
        this.items_num = items_num;
    }

    public Items getItems() {
        return items;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }


    }

