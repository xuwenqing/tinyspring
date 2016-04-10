package tinyspring.framework.beans.factory.support;

import tinyspring.framework.beans.factory.config.BeanDefinition;
import tinyspring.framework.beans.factory.config.BeanPostProcessor;
import tinyspring.framework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    public Object getBean(String name) {
        return doGetBean(name);
    }

    protected Object doGetBean(String name) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null)
            return sharedInstance;
        final BeanDefinition mbd = getBeanDefinition(name);
        Object bean = createBean(name, mbd);
        //将新创建的bean注册到单例容器中，spring源码采用ObjectFactory的方式
        super.registerSingleton(name, bean);
        return bean;
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition mbd);
}
