package tinyspring.framework.beans.config;

import tinyspring.framework.beans.BeanFactory;
import tinyspring.framework.beans.BeansException;

public interface AutowireCapableBeanFactory extends BeanFactory {
    <T> T createBean(Class<T> beanClass);
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws BeansException;
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException;
}
