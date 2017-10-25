package com.suhang.springmvc.po;

import java.util.Date;

/**
 * @author hang.su
 * @since 2017-09-23 11:45
 */
public class Orders {


    public int id;

    public int user_id;

    public String number;

    public Date creativetime;

    public String note;

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCreativetime(Date creativetime) {
        this.creativetime = creativetime;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getNumber() {
        return number;
    }

    public Date getCreativetime() {
        return creativetime;
    }

    public String getNote() {
        return note;
    }


}
