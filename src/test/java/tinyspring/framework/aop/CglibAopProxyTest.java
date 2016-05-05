package tinyspring.framework.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import tinyspring.framework.aop.demo.Interface;
import tinyspring.framework.aop.demo.SimpleClass;
import tinyspring.framework.aop.demo.SimpleInterface;

/**
 * Created by wenqing on 2016/5/5.
 */
public class CglibAopProxyTest {
    @Test
    public void testInterface() {
        TargetSource targetSource = new TargetSource(new SimpleInterface(),SimpleInterface.class,new Class[]{Interface.class});
        AdvisorSupport advisorSupport = new AdvisorSupport();
        advisorSupport.setTargetSource(targetSource);

        MethodInterceptor methodInterceptor = new SimpleMethodInterceptor();
        advisorSupport.setMethodInterceptor(methodInterceptor);

        AopProxy aopProxy = new CglibAopProxy(advisorSupport);
        SimpleInterface anInterface = (SimpleInterface)aopProxy.getProxy();

        anInterface.doSomething();
        anInterface.doSomething("Better");
    }

    @Test
    public void testClass() {
        TargetSource targetSource = new TargetSource(new SimpleClass(),SimpleClass.class,null);
        AdvisorSupport advisorSupport = new AdvisorSupport();
        advisorSupport.setTargetSource(targetSource);

        MethodInterceptor methodInterceptor = new SimpleMethodInterceptor();
        advisorSupport.setMethodInterceptor(methodInterceptor);

        AopProxy aopProxy = new CglibAopProxy(advisorSupport);
        SimpleClass simpleClass = (SimpleClass)aopProxy.getProxy();
        simpleClass.tooSimple();
        simpleClass.tooNaive();

    }
}
