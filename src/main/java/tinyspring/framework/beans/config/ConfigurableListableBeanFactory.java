package tinyspring.framework.beans.config;

import tinyspring.framework.beans.BeanFactory;

import java.util.List;

/**
 * Created by wenqing on 2016/4/11.
 */
public interface ConfigurableListableBeanFactory extends AutowireCapableBeanFactory, ConfigurableBeanFactory, BeanFactory {
    //1.ConfigurableBeanFactory，AbstractBeanFactory实现
    //2.AutowireCapableBeanFactory，AbstractAutowireCapableBeanFactory实现
    //3.ListableBeanFactory，DefaultListableBeanFactory实现
    List<Object> getBeansForType(Class clazz);
}
