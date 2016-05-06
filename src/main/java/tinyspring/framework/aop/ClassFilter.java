package tinyspring.framework.aop;

/**
 * Created by OGC on 2016/5/6.
 */
public interface ClassFilter {

    boolean matches(Class targetClass);
}
