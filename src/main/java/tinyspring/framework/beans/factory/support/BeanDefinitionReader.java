package tinyspring.framework.beans.factory.support;

import org.springframework.core.io.Resource;
import tinyspring.framework.beans.BeansException;

/**
 * Created by wenqing on 2016/4/10.
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();
    void loadBeanDefinitions(Resource resource) throws BeansException;
}
