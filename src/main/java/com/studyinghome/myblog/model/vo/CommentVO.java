package com.studyinghome.myblog.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class CommentVO implements Serializable {

    private Long id;
    private String nickName;
    private String site;
    private String createTime;
    private String content;
    private String toNickName;

}
