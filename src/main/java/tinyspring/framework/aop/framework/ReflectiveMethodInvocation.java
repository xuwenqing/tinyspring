package tinyspring.framework.aop.framework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * Created by wenqing on 2016/5/5.
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    private Method method;
    private Object proxied;
    private Object[] arguments;

    public ReflectiveMethodInvocation(Object proxied,Method method,Object[] arguments) {
        this.proxied = proxied;
        this.method = method;
        this.arguments = arguments;
    }

    public Method getMethod() {
        return this.method;
    }

    public Object[] getArguments() {
        return this.arguments;
    }

    public Object proceed() throws Throwable {
        return method.invoke(proxied,arguments);
    }

    public Object getThis() {
        return proxied;
    }

    public AccessibleObject getStaticPart() {
        return null;
    }
}
