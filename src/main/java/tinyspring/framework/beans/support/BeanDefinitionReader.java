package tinyspring.framework.beans.support;

import tinyspring.framework.core.io.Resource;
import tinyspring.framework.beans.BeansException;
import tinyspring.framework.core.io.ResourceLoader;

/**
 * Created by wenqing on 2016/4/10.
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... location) throws BeansException;
}
