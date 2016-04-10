package tinyspring.springframework.core.io;


import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wenqing on 2016/4/10.
 */
public class ClassPathResource implements Resource {
    private final String path;

    private ClassLoader classLoader;

    private Class<?> clazz;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path,ClassLoader classLoader) {
        Assert.assertNotNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader;
    }

    public ClassPathResource(String path, Class<?> clazz) {
        Assert.assertNotNull(path, "Path must not be null");
        this.path = path;
        this.clazz = clazz;
    }

    protected ClassPathResource(String path, ClassLoader classLoader, Class<?> clazz) {
        this.path = path;
        this.classLoader = classLoader;
        this.clazz = clazz;
    }

    public InputStream getInputStream() throws IOException {
        InputStream is;
        if (this.clazz != null) {
            is = this.clazz.getResourceAsStream(this.path);
        }
        else if (this.classLoader != null) {
            is = this.classLoader.getResourceAsStream(this.path);
        }
        else {
            is = ClassLoader.getSystemResourceAsStream(this.path);
        }
        if (is == null) {
            throw new FileNotFoundException("class path resource cannot be opened because it does not exist");
        }
        return is;
    }
}
