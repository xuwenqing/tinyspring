package tinyspring.framework.context;

import tinyspring.framework.beans.BeanFactory;
import tinyspring.framework.beans.ListableBeanFactory;
import tinyspring.framework.beans.config.AutowireCapableBeanFactory;

/**
 * Created by wenqing on 2016/4/11.
 */
public interface ApplicationContext extends ListableBeanFactory, BeanFactory {
    AutowireCapableBeanFactory getAutowireCapableBeanFactory();
}
