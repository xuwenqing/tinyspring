package tinyspring.framework.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import tinyspring.framework.aop.demo.Interface;
import tinyspring.framework.aop.demo.SimpleInterface;

/**
 * Created by wenqing on 2016/5/5.
 */
public class JdkDynamicAopProxyTest {
    @Test
    public void test() {
        TargetSource targetSource = new TargetSource(new SimpleInterface(),SimpleInterface.class,new Class[]{Interface.class});
        AdvisorSupport advisorSupport = new AdvisorSupport();
        advisorSupport.setTargetSource(targetSource);

        MethodInterceptor methodInterceptor = new SimpleMethodInterceptor();
        advisorSupport.setMethodInterceptor(methodInterceptor);

        AopProxy aopProxy = new JdkDynamicAopProxy(advisorSupport);
        Interface anInterface = (Interface)aopProxy.getProxy();

        anInterface.doSomething();
        anInterface.doSomething("Better");
    }

}
