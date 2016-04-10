package tinyspring.framework.beans.factory.config;

import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {
    <T> T createBean(Class<T> beanClass);
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws BeansException;
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException;
}
