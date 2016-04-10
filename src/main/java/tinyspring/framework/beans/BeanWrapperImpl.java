package tinyspring.framework.beans;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by wenqing on 2016/4/9.
 */
public class BeanWrapperImpl implements BeanWrapper {
    private Object instance;
    private PropertyValues propertyValues;

    public BeanWrapperImpl(Object instance) {
        this.instance = instance;
    }

    public Object getWrappedInstance() {
        return this.instance;
    }

    public void setPropertyValues(PropertyValues pvs) {
        this.propertyValues = pvs;
        if(this.propertyValues!=null) {
            for (PropertyValue pv : propertyValues.getPropertyValues()) {
                setPropertyValue(pv);
            }
        }
    }

     public void setPropertyValue(PropertyValue propertyValue) {
        //进行依赖注入
        Object value = propertyValue.getValue();
        try {
            Method declaredMethod = instance.getClass().getDeclaredMethod(
                    "set" + propertyValue.getName().substring(0, 1).toUpperCase()
                            + propertyValue.getName().substring(1), value.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance, value);
        } catch (NoSuchMethodException e) {
            try {
                Field declaredField = instance.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(instance, value);
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
