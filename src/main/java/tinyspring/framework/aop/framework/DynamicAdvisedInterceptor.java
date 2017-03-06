package tinyspring.framework.aop.framework;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInvocation;
import tinyspring.framework.aop.MethodMatcher;

import java.lang.reflect.Method;

/**
 * Created by wenqing on 2016/5/5.
 */
public class DynamicAdvisedInterceptor implements MethodInterceptor {

    private AdvisedSupport advisorSupport;

    public DynamicAdvisedInterceptor(AdvisedSupport advisorSupport) {
        this.advisorSupport = advisorSupport;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        MethodMatcher methodMatcher = advisorSupport.getMethodMatcher();
        TargetSource targetSource = advisorSupport.getTargetSource();

        //if (methodMatcher != null && methodMatcher.matches(method, targetSource.getTargetClass())) {
            MethodInvocation methodInvocation = new CglibMethodInvocation(targetSource.getTargetObject(), method, objects, methodProxy);
            org.aopalliance.intercept.MethodInterceptor methodInterceptor = advisorSupport.getMethodInterceptor();
            return methodInterceptor.invoke(methodInvocation);
       // }

       // return methodProxy.invoke(targetSource.getTargetObject(), objects);
    }
}
