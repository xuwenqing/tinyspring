package tinyspring.framework.beans.xml;

import org.xml.sax.InputSource;
import org.w3c.dom.Document;
/**
 * Created by wenqing on 2016/4/10.
 */
public interface DocumentLoader {
    Document loadDocument(InputSource inputSource) throws Exception;
}
