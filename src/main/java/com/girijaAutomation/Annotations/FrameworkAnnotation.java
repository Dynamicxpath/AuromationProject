package com.girijaAutomation.Annotations;


import com.girijaAutomation.Enum.CategoryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FrameworkAnnotation{

    public String[] author() ;
    public CategoryType[] category();


}