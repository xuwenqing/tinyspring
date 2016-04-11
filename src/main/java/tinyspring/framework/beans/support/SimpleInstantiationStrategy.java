package tinyspring.framework.beans.support;

import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.config.BeanDefinition;

/**
 * Created by wenqing on 2016/4/10.
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Object bean = null;
        try {
            bean = beanClass.newInstance();
        } catch (InstantiationException e) {
            throw new BeansException(beanDefinition.getBeanClassName()+"实例化异常",e);
        } catch (IllegalAccessException e) {
            throw new BeansException(beanDefinition.getBeanClassName()+"实例化非法访问异常",e);
        }
        return bean;
    }
}
