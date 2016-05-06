package tinyspring.framework.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

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
        TargetSource targetSource = getAdvisorSupport().getTargetSource();
        MethodInvocation methodInvocation = new ReflectiveMethodInvocation(targetSource.getTargetObject(),method,args);
        MethodInterceptor methodInterceptor = getAdvisorSupport().getMethodInterceptor();
        return methodInterceptor.invoke(methodInvocation);
    }
}
