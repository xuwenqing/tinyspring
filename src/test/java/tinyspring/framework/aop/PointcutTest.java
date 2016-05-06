package tinyspring.framework.aop;

import junit.framework.Assert;
import org.junit.Test;
import tinyspring.framework.aop.support.SimpleClass;
import tinyspring.framework.aop.support.AspectJExpressionPointcut;

/**
 * Created by OGC on 2016/5/6.
 */
public class PointcutTest {
    @Test
    public void classFilter() {
        String expression = "execution(* tinyspring.framework.aop.support.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(SimpleClass.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void methodMatcher() throws Exception {
        String expression = "execution(* tinyspring.framework.aop.support.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(SimpleClass.class.getDeclaredMethod("tooNaive"), SimpleClass.class);
        Assert.assertTrue(matches);
    }
}
