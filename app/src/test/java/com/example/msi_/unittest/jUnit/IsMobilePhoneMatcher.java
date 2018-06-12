package com.example.msi_.unittest.jUnit;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.util.regex.Pattern;

/**
 * 创建者：ZC
 * 创建日期： 2018/6/12 15:31
 * 描述：
 **/
public class IsMobilePhoneMatcher extends BaseMatcher<String> {
    @Override
    public boolean matches(Object item) {
        if (item==null) {
            return false;
        }
        Pattern pattern = Pattern.compile("(1|861)(3|5|7|8)\\d{9}$*");
        java.util.regex.Matcher matcher = pattern.matcher((String)item);
        return matcher.find();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("此号码是手机号码");
    }

    @Override
    public void describeMismatch(Object item, Description description) {
       description.appendText("此号码不是手机号码");
    }
}
