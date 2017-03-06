package tinyspring.framework.aop.support;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by wenqing on 2016/5/5.
 */
public class SimpleMethodInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("SimpleMethodInterceptor doSomething");
        Object o = invocation.proceed();
        System.out.println(invocation.getMethod());
        return o;
    }
}
