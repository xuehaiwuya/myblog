package com.studyinghome.myblog.enums;

/**
 * ${文章状态}
 *
 * @author panxiang
 * @create 2018-04-17 22:30
 */
public enum ArticleStatusEnum {

    ALL(-1, "所有"),
    SHOW(0, "显示"),
    HIDDEN(1, "隐藏"),
    ;

    private final int key;
    private final String value;

    ArticleStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
