package tinyspring.framework.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import tinyspring.framework.aop.MethodMatcher;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wenqing on 2016/5/5.
 */
public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler{

    public JdkDynamicAopProxy(AdvisedSupport advisorSupport) {
        super(advisorSupport);
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                getAdvisorSupport().getTargetSource().getInterfaceClasses(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        MethodMatcher methodMatcher = getAdvisorSupport().getMethodMatcher();
        TargetSource targetSource = getAdvisorSupport().getTargetSource();

        if (methodMatcher != null && methodMatcher.matches(method, targetSource.getTargetClass())) {
            MethodInvocation methodInvocation = new ReflectiveMethodInvocation(targetSource.getTargetObject(), method, args);
            MethodInterceptor methodInterceptor = getAdvisorSupport().getMethodInterceptor();
            return methodInterceptor.invoke(methodInvocation);
        }

        return method.invoke(targetSource.getTargetObject(), args);
    }
}
