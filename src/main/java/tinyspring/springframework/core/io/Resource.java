package tinyspring.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wenqing on 2016/4/10.
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
