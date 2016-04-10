package tinyspring.framework.beans.factory.support;

import tinyspring.framework.beans.BeanWrapper;
import tinyspring.framework.beans.BeanWrapperImpl;
import tinyspring.framework.beans.PropertyValue;
import tinyspring.framework.beans.PropertyValues;
import tinyspring.framework.beans.factory.config.AutowireCapableBeanFactory;
import tinyspring.framework.beans.factory.config.BeanDefinition;

import java.util.List;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory
        implements AutowireCapableBeanFactory {

    /** Strategy for creating bean instances */
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    protected InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }

    public <T> T createBean(Class<T> beanClass) {
        RootBeanDefinition mbd = new RootBeanDefinition(beanClass);
        return (T) createBean(beanClass.getName(), mbd);
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition mbd) {
        // Instantiate the bean.
        BeanWrapper instanceWrapper = createBeanInstance(mbd);
        // Initialize the bean instance.
        Object exposedObject = (instanceWrapper != null ? instanceWrapper.getWrappedInstance() : null);
        populateBean(mbd, instanceWrapper);
        return exposedObject;
    }

    protected BeanWrapper createBeanInstance(BeanDefinition mbd) {
        Object beanInstance = getInstantiationStrategy().instantiate(mbd);
        BeanWrapper beanWrapper = new BeanWrapperImpl(beanInstance);
        return beanWrapper;
    }

    protected void populateBean(BeanDefinition mbd, BeanWrapper bw) {
        //这里取得BeanDefinition中的property值
        PropertyValues pvs = mbd.getPropertyValues();

        //省略在设置属性之前调用Bean的PostProcessor后置处理器
        //开始进行依赖注入过程，先处理autowire的注入
        //使用BeanPostProcessor处理器处理属性值

        //对属性进行依赖注入
        if(pvs!=null && pvs.getPropertyValues() != null)
            applyPropertyValues(mbd, bw, pvs);
    }

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




}
