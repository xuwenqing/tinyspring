package tinyspring.framework.aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by wenqing on 2016/5/5.
 */
public class CglibDynamicMethodIntercetor implements MethodInterceptor {

    private AdvisorSupport advisorSupport;

    public CglibDynamicMethodIntercetor(AdvisorSupport advisorSupport) {
        this.advisorSupport = advisorSupport;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        TargetSource targetSource = advisorSupport.getTargetSource();
        MethodInvocation methodInvocation = new CglibMethodInvocation(targetSource.getTargetObject(),method,objects,methodProxy);
        org.aopalliance.intercept.MethodInterceptor methodInterceptor = advisorSupport.getMethodInterceptor();
        return methodInterceptor.invoke(methodInvocation);
    }
}
