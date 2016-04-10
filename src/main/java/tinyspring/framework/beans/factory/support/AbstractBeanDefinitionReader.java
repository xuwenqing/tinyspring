package tinyspring.framework.beans.factory.support;

/**
 * Created by wenqing on 2016/4/10.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;
    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }
}
