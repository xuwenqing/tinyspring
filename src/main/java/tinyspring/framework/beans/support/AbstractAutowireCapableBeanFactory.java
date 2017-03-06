package tinyspring.framework.beans.support;

import tinyspring.framework.beans.*;
import tinyspring.framework.beans.config.BeanDefinition;
import tinyspring.framework.beans.InitializingBean;
import tinyspring.framework.beans.config.AutowireCapableBeanFactory;
import tinyspring.framework.beans.config.BeanPostProcessor;

import java.util.List;

/**
 * 该类实际调用实例化策略创建Bean对象
 * 并对创建后的对象执行初始化方法，BeanPostProcessors的方法
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory
        implements AutowireCapableBeanFactory {

    /**
     * 实例化bean的策略
     */
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    protected InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }

    /**
     * bean的实例化过程
     * @param beanName
     * @param mbd
     * @return 返回创建的bean
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition mbd) {
        //实例化bean对象
        BeanWrapper instanceWrapper = createBeanInstance(mbd);
        //bean实例
        Object exposedObject = instanceWrapper.getWrappedInstance();
        //解决循环依赖，将新创建的bean注册到单例容器中，spring源码采用ObjectFactory的方式
        registerSingleton(beanName, exposedObject);
        //设置对象属性，依赖注入
        populateBean(mbd, instanceWrapper);
        if (exposedObject != null) {
            //对实例化对象在使用前进行aware接口处理,BeanPostProcessor前置处理，init-method处理，BeanPostProcessor后置处理
            exposedObject = initializeBean(beanName, exposedObject, mbd);
        }
        return exposedObject;
    }

    /**
     *创建一个bean实例并封在在BeanWrapper中
     */
    protected BeanWrapper createBeanInstance(BeanDefinition mbd) {
        Object beanInstance = getInstantiationStrategy().instantiate(mbd);
        BeanWrapper beanWrapper = new BeanWrapperImpl(beanInstance);
        return beanWrapper;
    }

    /**
     * 设置对象属性，autowire,普通注入多种形式
     * 并且在这里实现一些对象属性的短路处理，InstantiationAwareBeanPostProcessors，这里不予实现
     * 这里只实现普通的依赖注入
     */
    protected void populateBean(BeanDefinition mbd, BeanWrapper bw) {
        //这里取得BeanDefinition中的property值
        PropertyValues pvs = mbd.getPropertyValues();

        //开始进行依赖注入过程，先处理autowire的注入
        //使用InstantiationAwareBeanPostProcessors处理属性值
        //用户自定义类型转换

        //对属性进行普通依赖注入
        if(pvs!=null && pvs.getPropertyValues() != null)
            applyPropertyValues(mbd, bw, pvs);
    }

    /**
     * 设置对象属性
     */
    protected void applyPropertyValues(BeanDefinition mbd, BeanWrapper bw, PropertyValues pvs) {
        //省略对自定义的类型转换等操作
        //创建一个Bean定义属性值解析器，将Bean定义中的属性值解析为Bean实例对象的实际值
        BeanDefinitionValueResolver valueResolver = new BeanDefinitionValueResolver(this);
        List<PropertyValue> original = pvs.getPropertyValues();
        for (PropertyValue pv : original) {
            Object originalValue = pv.getValue();
            //转换属性
            Object resolvedValue = valueResolver.resolveValueIfNecessary(originalValue);
            //设置属性转换之后的值
            pv.setValue(resolvedValue);
        }
        //这里是依赖注入发生的地方
        bw.setPropertyValues(pvs);
    }

    //对实例化对象在使用前进行aware接口处理,BeanPostProcessor前置处理，init-mthod处理，BeanPostProcessor后置处理
    protected Object initializeBean(final String beanName, final Object bean, BeanDefinition mbd) {
        invokeAwareMethods(beanName, bean);
        Object wrappedBean = bean;
        wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
        invokeInitMethods(beanName, wrappedBean, mbd);
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    //检查Aware相关接口
    private void invokeAwareMethods(final String beanName, final Object bean) {
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
    }

    //初始化方法
    protected void invokeInitMethods(String beanName, final Object bean, BeanDefinition mbd) {
        if(bean instanceof InitializingBean) {
            logger.info(beanName+"init-method");
            ((InitializingBean) bean).afterPropertiesSet();
        }
    }

    //PostProcessors前置处理
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanProcessor : getBeanPostProcessors()) {
            result = beanProcessor.postProcessBeforeInitialization(result, beanName);
            if (result == null) {
                return result;
            }
        }
        return result;
    }

    //PostProcessors后置处理
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanProcessor : getBeanPostProcessors()) {
            result = beanProcessor.postProcessAfterInitialization(result, beanName);
            if (result == null) {
                return result;
            }
        }
        return result;
    }
}
