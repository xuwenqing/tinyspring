package tinyspring.framework.core.io;

import org.junit.Assert;

/**
 * Created by wenqing on 2016/4/10.
 */
public class DefaultResourceLoader implements ResourceLoader {

    private ClassLoader classLoader;

    public DefaultResourceLoader() {
        this.classLoader = ClassLoader.getSystemClassLoader();
    }

    public DefaultResourceLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return (this.classLoader != null ? this.classLoader : ClassLoader.getSystemClassLoader());
    }

    public Resource getResource(String location) {
        Assert.assertNotNull(location, "Location must not be null");
        //以后可用于FileSystemXmlApplicationContext的扩展
        //覆写getResourceByPath方法
        return getResourceByPath(location);
    }

    protected Resource getResourceByPath(String path) {
        return new ClassPathResource(path, getClassLoader());
    }

}

