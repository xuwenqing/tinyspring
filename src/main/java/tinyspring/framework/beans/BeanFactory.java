package tinyspring.framework.beans;

import java.util.List;

public interface BeanFactory {
    Object getBean(String name);
    List<Object> getBeansForType(Class clazz);
}
