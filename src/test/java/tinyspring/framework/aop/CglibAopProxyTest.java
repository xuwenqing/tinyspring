package tinyspring.framework.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import tinyspring.framework.aop.support.*;
import tinyspring.framework.aop.framework.AdvisedSupport;
import tinyspring.framework.aop.framework.AopProxy;
import tinyspring.framework.aop.framework.CglibAopProxy;
import tinyspring.framework.aop.framework.TargetSource;

/**
 * Created by wenqing on 2016/5/5.
 */
public class CglibAopProxyTest {
    @Test
    public void testInterface() {
        TargetSource targetSource = new TargetSource(new SimpleInterface(),SimpleInterface.class,new Class[]{Interface.class});
        AdvisedSupport advisorSupport = new AdvisedSupport();
        advisorSupport.setTargetSource(targetSource);

        MethodInterceptor methodInterceptor = new SimpleMethodInterceptor();
        advisorSupport.setMethodInterceptor(methodInterceptor);

        String expression = "execution(* tinyspring.framework.aop.support.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        advisorSupport.setMethodMatcher(aspectJExpressionPointcut);

        AopProxy aopProxy = new CglibAopProxy(advisorSupport);
        SimpleInterface anInterface = (SimpleInterface)aopProxy.getProxy();

        anInterface.doSomething();
        anInterface.doSomething("Better");
    }

    @Test
    public void testClass() {
        TargetSource targetSource = new TargetSource(new SimpleClass(),SimpleClass.class,null);
        AdvisedSupport advisorSupport = new AdvisedSupport();
        advisorSupport.setTargetSource(targetSource);

        MethodInterceptor methodInterceptor = new SimpleMethodInterceptor();
        advisorSupport.setMethodInterceptor(methodInterceptor);

        AopProxy aopProxy = new CglibAopProxy(advisorSupport);
        SimpleClass simpleClass = (SimpleClass)aopProxy.getProxy();
        simpleClass.tooSimple();
        simpleClass.tooNaive();

    }
}
