package tinyspring.framework.beans.config;

import tinyspring.framework.beans.ListableBeanFactory;

/**
 * Created by wenqing on 2016/4/11.
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    //ConfigurableBeanFactory 继承 HierarchicalBeanFactory
    //1.ConfigurableBeanFactory，AbstractBeanFactory实现
    //2.AutowireCapableBeanFactory，AbstractAutowireCapableBeanFactory实现
    //3.ListableBeanFactory，DefaultListableBeanFactory实现
}
