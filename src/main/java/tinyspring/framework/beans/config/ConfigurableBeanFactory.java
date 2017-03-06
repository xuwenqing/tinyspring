package tinyspring.framework.beans.config;

import tinyspring.framework.beans.BeanFactory;


public interface ConfigurableBeanFactory extends BeanFactory {
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
