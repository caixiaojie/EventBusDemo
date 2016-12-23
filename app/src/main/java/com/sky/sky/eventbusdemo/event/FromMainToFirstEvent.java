package com.sky.sky.eventbusdemo.event;

/**
 * Created by BlueSky on 16/12/23.
 */

public    class FromMainToFirstEvent {

    String str;


    public FromMainToFirstEvent() {
    }

    public FromMainToFirstEvent(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
