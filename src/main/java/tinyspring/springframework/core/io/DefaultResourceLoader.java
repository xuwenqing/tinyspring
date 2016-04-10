package tinyspring.springframework.core.io;

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
        return new ClassPathResource(location,getClassLoader());
    }

}

