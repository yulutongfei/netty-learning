package com.sunxu.recycler;

import io.netty.util.Recycler;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/1/28 13:42
 */
public class UserCache {

    private static final Recycler<User> USER_RECYCLER = new Recycler<User>() {
        @Override
        protected User newObject(Handle<User> handle) {
            return new User(handle);
        }
    };

    public static void main(String[] args) {
        User user = USER_RECYCLER.get();
        System.out.println(user);
        user.recycle();
        User user1 = USER_RECYCLER.get();
        System.out.println(user1);
    }
}
