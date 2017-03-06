package tinyspring.framework.aop.support;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by wenqing on 2017/3/6.
 */
public class LogInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long time = System.nanoTime();
        System.out.println("LogInterceptor Invocation of Method " + invocation.getMethod().getName() + " start!");
        Object proceed = invocation.proceed();
        System.out.println("LogInterceptor Invocation of Method " + invocation.getMethod().getName() + " end!");
        return proceed;
    }
}
