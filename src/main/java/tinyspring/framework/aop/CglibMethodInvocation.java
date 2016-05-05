package tinyspring.framework.aop;

import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by wenqing on 2016/5/5.
 */
public class CglibMethodInvocation extends ReflectiveMethodInvocation {

    private MethodProxy methodProxy;

    public CglibMethodInvocation(Object proxied, Method method, Object[] arguments, MethodProxy methodProxy) {
        super(proxied, method, arguments);
        this.methodProxy = methodProxy;
    }

    @Override
    public Object proceed() throws Throwable {
        return methodProxy.invoke(getThis(),getArguments());
    }
}
