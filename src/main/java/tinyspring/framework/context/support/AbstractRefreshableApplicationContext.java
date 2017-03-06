package tinyspring.framework.context.support;

import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.config.ConfigurableListableBeanFactory;
import tinyspring.framework.beans.support.DefaultListableBeanFactory;

/**
 * Created by wenqing on 2016/4/11.
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    /**
     * Context中BeanFactory
     */
    private DefaultListableBeanFactory beanFactory;

    public AbstractRefreshableApplicationContext() {
    }

    @Override
    protected final void refreshBeanFactory() throws BeansException {
        //创建默认工厂
        beanFactory = new DefaultListableBeanFactory();
        //加载BeanDefinitions
        loadBeanDefinitions(beanFactory);
    }

    @Override
    public final ConfigurableListableBeanFactory getBeanFactory() {
        if (this.beanFactory == null) {
            throw new IllegalStateException("BeanFactory未实例化");
        }
        return this.beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory)
            throws BeansException;
}
