package com.example.msi_.unittest.jUnit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * 创建者：ZC
 * 创建日期： 2018/6/12 15:41
 * 描述：自定义Rule
 **/
public class MyRule implements TestRule {
    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                String methodName = description.getMethodName();
                System.out.println("测试方法"+methodName+" 开始");

                base.evaluate();
                System.out.println("测试方法"+methodName+" 结束");
            }
        };
    }
}
