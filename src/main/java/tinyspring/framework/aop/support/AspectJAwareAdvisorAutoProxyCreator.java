package tinyspring.framework.aop.support;

import org.aopalliance.intercept.MethodInterceptor;
import tinyspring.framework.aop.framework.TargetSource;
import tinyspring.framework.aop.support.AspectJExpressionPointcutAdvisor;
import tinyspring.framework.aop.support.ProxyFactory;
import tinyspring.framework.beans.BeanFactory;
import tinyspring.framework.beans.BeanFactoryAware;
import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.config.BeanPostProcessor;

import java.util.List;

/**
 * Created by wenqing on 2017/3/6.
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor, BeanFactoryAware {
    private BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AspectJExpressionPointcutAdvisor) {
            return bean;
        }
        if (bean instanceof MethodInterceptor) {
            return bean;
        }

        List<AspectJExpressionPointcutAdvisor> advisors = (List)beanFactory
                .getBeansForType(AspectJExpressionPointcutAdvisor.class);
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            if (advisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                ProxyFactory advisedSupport = new ProxyFactory();
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

                TargetSource targetSource = new TargetSource(bean, bean.getClass(), bean.getClass().getInterfaces());
                advisedSupport.setTargetSource(targetSource);

                return advisedSupport.getProxy();
            }
        }
        return bean;
    }
}
