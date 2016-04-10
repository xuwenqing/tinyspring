package tinyspring.framework.beans.factory.config;

import tinyspring.framework.beans.BeansException;

/**
 * Created by wenqing on 2016/4/10.
 */
public interface BeanPostProcessor {
    //前置处理
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;
    //后置处理
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
