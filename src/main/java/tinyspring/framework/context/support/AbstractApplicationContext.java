package tinyspring.framework.context.support;

import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.config.AutowireCapableBeanFactory;
import tinyspring.framework.beans.config.ConfigurableListableBeanFactory;
import tinyspring.framework.context.ConfigurableApplicationContext;
import tinyspring.framework.core.io.DefaultResourceLoader;

/**
 * Created by wenqing on 2016/4/11.
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader
        implements ConfigurableApplicationContext {

    public AbstractApplicationContext() {

    }

    //---------------------------------------------------------------------
    // 实现ConfigurableApplicationContext的接口
    //---------------------------------------------------------------------
    public void refresh() throws BeansException {
        // 准备刷新容器, 获取容器的当时时间, 同时给容器设置同步标识
        //prepareRefresh();

        // 启动子类的refreshBeanFactory方法.
        ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

        // 为BeanFactory配置容器特性，例如类加载器、事件处理器，BeanPostProcessor,设置IgnoreAware等.
        // prepareBeanFactory(beanFactory);

        // 设置BeanFactory的后置处理（BeanFactoryPostProcessor）.比如PropertyEditorRegistrar，PlaceHolder
        //postProcessBeanFactory(beanFactory);

        // 调用BeanFactory的后处理器, 这些后处理器是在Bean定义中向容器注册的.
        // 加载完BeanDefinition后，对BeanDefinition的进一步处理
        //invokeBeanFactoryPostProcessors(beanFactory);

        // 注册Bean的后处理器, 在Bean创建过程中调用.
        //registerBeanPostProcessors(beanFactory);

        // 初始化上下文中的消息源.
        //initMessageSource();

        // 初始化上下文中的事件机制.
        //initApplicationEventMulticaster();

        // 初始化其它特殊的Bean.
        //onRefresh();

        // 检查并向容器注册监听器Bean.
        //registerListeners();

        // 实例化所有剩余的(non-lazy-init) 单例Bean.
        //finishBeanFactoryInitialization(beanFactory);

        // 发布容器事件, 结束refresh过程.
        //finishRefresh();
    }

    protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
        //调用子类实现
        refreshBeanFactory();
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        return beanFactory;
    }

    //---------------------------------------------------------------------
    // 实现ApplicationContext中的接口
    //---------------------------------------------------------------------
    public AutowireCapableBeanFactory getAutowireCapableBeanFactory() {
        return getBeanFactory();
    }

    //BeanFactory中的接口
    public Object getBean(String name) {
        return getBeanFactory().getBean(name);
    }

    /*
     * 子类实现
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    public abstract ConfigurableListableBeanFactory getBeanFactory();

}
