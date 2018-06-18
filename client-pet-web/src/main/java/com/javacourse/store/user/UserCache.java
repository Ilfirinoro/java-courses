package com.javacourse.store.user;

import com.javacourse.model.User;

import java.util.UUID;

public class UserCache extends Cache<UUID, User> {

    private static UserCache instance;

    public static UserCache getInstance() {
        if (instance == null) {
            synchronized (Cache.class) {
                if (instance == null) {
                    instance = new UserCache();
                }
            }
        }
        return instance;
    }
}
