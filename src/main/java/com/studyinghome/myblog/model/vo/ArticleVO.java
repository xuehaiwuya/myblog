package com.studyinghome.myblog.model.vo;

import com.studyinghome.myblog.common.util.HtmlUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class ArticleVO implements Serializable {

    private static final long serialVersionUID = 8355902141000751051L;

    private Long id;
    private String title;
    private String fixedLink;
    private String content;
    private String html;
    private Integer isShow;
    private Integer sortValue;
    private Long createUser;
    private String createUserName;
    private Date createTime;
    private Long categoryId;
    private String tags;
    private Long pv;
    
    public List<String> getTagList() {
    	List<String> list = null;
    	if (StringUtils.isNotBlank(tags)) {
    		String[] split = tags.split("\\,");
    		list = Arrays.asList(split);
		}
    	return list;
    }
    
    public String getDesc() {
    	String desc = HtmlUtil.getTextFromHtml(html);
    	if (StringUtils.isBlank(desc)) {
			return desc;
		}
    	return desc.length() > 200 ? desc.substring(0, 200) : desc;
    }

}
