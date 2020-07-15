package com.qf.ecms.utils;

import org.apache.ibatis.annotations.Param;


public class TestReg {

    /**
     * 国际电话号码验证
     以数字或+开头
     后面的必须是数字长度在 12 到 13
     */
    public boolean testTel(String tel)
    {
        String regex="[+\\d]?\\d{11}";
        return tel.matches(regex);
    }

    /**
     * 注册电子邮箱验证
     邮箱地址必须包含@字符
     邮箱@的左边必须以字母, 下划线, 数字开头, 且必须有一个
     邮箱@的左边除了开头字母其他的可以是字母, 下划线, 数字， 点号 . 小杠 -
     邮箱@的右边必须有 . 点号
     在 @ 和 . 之间必须以字母, 下划线, 数字开头, 且除了开头字母其他的可以是字母, 下划线, 数字， 点号 . 小杠 -
     在 . 点号后面至少有一个 字母, 下划线, 数字开头

     */
    public  boolean testEmail(String email)
    {
        String regex="(\\w+)([\\w+.-])*@(\\w+)([\\w+.-])*\\.\\w+";
        return email.matches(regex);
    }

}
