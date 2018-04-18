package com.studyinghome.myblog.common.security;

/**
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public class SessionUserContext {

    private static ThreadLocal<IUser> users = new ThreadLocal<>();

    static void put(IUser user) {
        users.set(user);
    }

    public static IUser get() {
        return users.get();
    }
}
