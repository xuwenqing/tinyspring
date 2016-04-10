package tinyspring.framework.beans.factory.config;

import tinyspring.framework.beans.factory.HierarchicalBeanFactory;


public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
