package tinyspring.framework.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import tinyspring.framework.aop.support.Interface;
import tinyspring.framework.aop.support.SimpleInterface;
import tinyspring.framework.aop.framework.AdvisedSupport;
import tinyspring.framework.aop.framework.AopProxy;
import tinyspring.framework.aop.framework.JdkDynamicAopProxy;
import tinyspring.framework.aop.framework.TargetSource;
import tinyspring.framework.aop.support.AspectJExpressionPointcut;
import tinyspring.framework.aop.support.SimpleMethodInterceptor;

/**
 * Created by wenqing on 2016/5/5.
 */
public class JdkDynamicAopProxyTest {
    @Test
    public void test() {
        TargetSource targetSource = new TargetSource(new SimpleInterface(),SimpleInterface.class,new Class[]{Interface.class});
        AdvisedSupport advisorSupport = new AdvisedSupport();
        advisorSupport.setTargetSource(targetSource);

        MethodInterceptor methodInterceptor = new SimpleMethodInterceptor();
        advisorSupport.setMethodInterceptor(methodInterceptor);

        String expression = "execution(* tinyspring.framework.aop.support.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        advisorSupport.setMethodMatcher(aspectJExpressionPointcut);


        AopProxy aopProxy = new JdkDynamicAopProxy(advisorSupport);
        Interface anInterface = (Interface)aopProxy.getProxy();

        anInterface.doSomething();
        anInterface.doSomething("Better");
    }

}
