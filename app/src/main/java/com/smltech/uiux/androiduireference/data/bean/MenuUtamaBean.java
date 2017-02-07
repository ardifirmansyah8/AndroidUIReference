package com.smltech.uiux.androiduireference.data.bean;

import java.io.Serializable;

/**
 * Created by ryanzulham on 1/1/17.
 */

public class MenuUtamaBean implements Serializable {

    private String menuName;


    public MenuUtamaBean(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
