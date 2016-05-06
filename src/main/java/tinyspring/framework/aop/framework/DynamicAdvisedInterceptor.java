package tinyspring.framework.aop.framework;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInvocation;

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
        TargetSource targetSource = advisorSupport.getTargetSource();
        MethodInvocation methodInvocation = new CglibMethodInvocation(targetSource.getTargetObject(),method,objects,methodProxy);
        org.aopalliance.intercept.MethodInterceptor methodInterceptor = advisorSupport.getMethodInterceptor();
        return methodInterceptor.invoke(methodInvocation);
    }
}
