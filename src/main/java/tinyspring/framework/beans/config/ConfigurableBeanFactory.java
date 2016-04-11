package tinyspring.framework.beans.config;

import tinyspring.framework.beans.HierarchicalBeanFactory;


public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
