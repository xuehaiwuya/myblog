package com.studyinghome.myblog.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class SysParamVO {

    private String uploadUrl;//上传图片路径
    private String title;//博客标题
    private String author;//博客作者
    private String wxpay;//微信收款url

}
