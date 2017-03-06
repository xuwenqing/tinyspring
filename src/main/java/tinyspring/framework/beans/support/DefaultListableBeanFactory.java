package tinyspring.framework.beans.support;

import tinyspring.framework.beans.config.BeanDefinition;
import tinyspring.framework.beans.config.ConfigurableListableBeanFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
        implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {

    //BeanDefinition容器
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);

    public DefaultListableBeanFactory() {
    }

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    public List getBeansForType(Class type) {
        List beans = new ArrayList<Object>();
        for (Map.Entry<String,BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition bd = entry.getValue();
            if (type.isAssignableFrom(bd.getBeanClass())) {
                beans.add(getBean(beanName));
            }
        }
        return beans;
    }
}
