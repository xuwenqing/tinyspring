package tinyspring.framework.beans.support;

import tinyspring.framework.beans.config.BeanDefinition;
import tinyspring.framework.beans.config.ConfigurableBeanFactory;
import tinyspring.framework.beans.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;

//实现ConfigurableBeanFactory中的接口
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
        return bean;
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    //工厂方法模式
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    //工厂方法模式
    protected abstract Object createBean(String beanName, BeanDefinition mbd);
}
