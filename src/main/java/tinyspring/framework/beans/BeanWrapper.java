package tinyspring.framework.beans;

/**
 * Created by wenqing on 2016/4/9.
 */
public interface BeanWrapper {
    Object getWrappedInstance();
    void setPropertyValues(PropertyValues pvs);
}
