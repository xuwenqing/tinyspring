package tinyspring.framework.beans.support;

import tinyspring.framework.beans.support.Hello;

/**
 * Created by OGC on 2016/4/8.
 */
public class HelloBean {
    private Hello hello;
    private String stringbean;

    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public void hello() {
        System.out.println("hello beanfactory..."+hello+" "+stringbean);
    }
}
