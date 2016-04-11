package tinyspring.framework.beans.support;

import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.config.BeanDefinition;

/**
 * Created by wenqing on 2016/4/10.
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
