package com.mao.zi.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by mashaohu on 15/12/16.
 * Description:
 */
public class Person extends BmobObject {

    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
