package tinyspring.framework.aop.framework;

/**
 * Created by wenqing on 2016/5/5.
 */
public class TargetSource {
    private Class<?> targetClass;
    private Class[] interfaceClasses;
    private Object targetObject;

    public TargetSource(Object targetObject, Class<?> targetClass, Class[] interfaceClasses) {
        this.targetClass = targetClass;
        this.interfaceClasses = interfaceClasses;
        this.targetObject = targetObject;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public Class[] getInterfaceClasses() {
        return interfaceClasses;
    }

    public void setInterfaceClasses(Class[] interfaceClasses) {
        this.interfaceClasses = interfaceClasses;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }
}
