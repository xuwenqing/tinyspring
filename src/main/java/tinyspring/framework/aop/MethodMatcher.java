package tinyspring.framework.aop;

import java.lang.reflect.Method;

/**
 * Created by OGC on 2016/5/6.
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);
}
