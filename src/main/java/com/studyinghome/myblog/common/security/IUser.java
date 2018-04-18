package com.studyinghome.myblog.common.security;

/**
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public interface IUser extends java.io.Serializable {

    Long getId();

    String getUsername();

    String getNickName();

}
