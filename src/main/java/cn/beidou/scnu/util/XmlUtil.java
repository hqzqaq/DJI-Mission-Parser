package cn.beidou.scnu.util;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.*;

/**
 * xml 工具类
 *
 * @author hqzqaq
 * @ClassName XmlUtil
 * @createTime 2023年03月20日 14:54:00
 */
public class XmlUtil {
    /**
     * JavaBean对象转换xml字符串
     */
    public static String objectToXML(Object object) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller m = context.createMarshaller();
        // 设置格式化输出
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        Writer w = new StringWriter();
        m.marshal(object, w);
        return w.toString();
    }

    /**
     * JavaBean对象转换xml文件
     */
    public static File objectToXML(Object object, String fileName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller m = context.createMarshaller();
        // 设置格式化输出
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.FALSE);
        File file = new File(fileName);
        m.marshal(object, file);
        return file;
    }

    /**
     * xml字符串转换为JavaBean对象
     */
    public static <T> T xmlToBean(String xml, Class<T> clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller um = context.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        return (T) um.unmarshal(sr);
    }

    /**
     * xml文件转换为JavaBean对象
     */
    public static <T> T xmlToBean(File file, Class<T> clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller um = context.createUnmarshaller();

        return (T) um.unmarshal(file);
    }


    @SuppressWarnings("unchecked")
    /**
     * 将file类型的xml转换成对象
     */
    public static Object convertXmlFileToObject(Class clazz, File file) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fr = null;
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            xmlObject = unmarshaller.unmarshal(fr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    /**
     * 解析xml（忽略命名空间）
     *
     * @param cla
     * @param content
     * @return
     * @throws JAXBException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public static Object unmarshall(Class<?> cla, String content) throws JAXBException, ParserConfigurationException, SAXException {

        JAXBContext jaxbContext = JAXBContext.newInstance(cla);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(content);

        SAXParserFactory sax = SAXParserFactory.newInstance();
        sax.setNamespaceAware(false);
        XMLReader xmlReader = sax.newSAXParser().getXMLReader();

        Source source = new SAXSource(xmlReader, new InputSource(reader));
        Object o = unmarshaller.unmarshal(source);

        return o;
    }
}
