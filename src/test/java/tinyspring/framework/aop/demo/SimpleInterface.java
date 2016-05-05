package tinyspring.framework.aop.demo;

/**
 * Created by wenqing on 2016/5/5.
 */
public class SimpleInterface implements Interface {

    public void doSomething() {
        System.out.println("doSomething");
    }

    public void doSomething(String args) {
        System.out.println("doSomething " + args);
    }
}
