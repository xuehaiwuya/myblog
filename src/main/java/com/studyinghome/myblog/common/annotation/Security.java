package com.studyinghome.myblog.common.annotation;

import java.lang.annotation.*;

/**
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Security {
    
    String name() default "";
    String type() default "";

}
