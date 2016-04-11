package tinyspring.framework.context.support;

import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.config.ConfigurableListableBeanFactory;
import tinyspring.framework.beans.support.DefaultListableBeanFactory;

/**
 * Created by wenqing on 2016/4/11.
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    /**
     * Bean factory for this context
     */
    private DefaultListableBeanFactory beanFactory;

    public AbstractRefreshableApplicationContext() {
    }

    @Override
    protected final void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        //加载BeanDefinitions
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    public final ConfigurableListableBeanFactory getBeanFactory() {
        if (this.beanFactory == null) {
            throw new IllegalStateException("BeanFactory not initialized or already closed - " +
                    "call 'refresh' before accessing beans via the ApplicationContext");
        }
        return this.beanFactory;
    }

    protected DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory)
            throws BeansException;
}
