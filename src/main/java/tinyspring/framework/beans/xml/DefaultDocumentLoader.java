package tinyspring.framework.beans.xml;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by wenqing on 2016/4/10.
 */
public class DefaultDocumentLoader implements DocumentLoader {
    public Document loadDocument(InputSource inputSource) throws Exception {
        DocumentBuilderFactory factory = createDocumentBuilderFactory();
        DocumentBuilder builder = createDocumentBuilder(factory);
        return builder.parse(inputSource);
    }

    protected DocumentBuilderFactory createDocumentBuilderFactory() {
        return DocumentBuilderFactory.newInstance();
    }

    protected DocumentBuilder createDocumentBuilder(DocumentBuilderFactory factory) throws ParserConfigurationException {
        return factory.newDocumentBuilder();
    }
}
