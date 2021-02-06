package com.sunxu.recycler;

import io.netty.util.Recycler;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/1/28 13:41
 */
public class User {

    private String name;

    private Recycler.Handle<User> handle;

    public User(Recycler.Handle<User> handle) {
        this.handle = handle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Recycler.Handle<User> getHandle() {
        return handle;
    }

    public void setHandle(Recycler.Handle<User> handle) {
        this.handle = handle;
    }

    public void recycle() {
        handle.recycle(this);
    }
}
