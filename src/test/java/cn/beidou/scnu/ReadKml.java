package cn.beidou.scnu;

import cn.beidou.scnu.dji.Kml;
import cn.beidou.scnu.util.XmlUtil;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * 读取kml文件内容
 *
 * @author hqzqaq
 * @ClassName ReadKml
 * @createTime 2024年07月18日 19:30:00
 */
public class ReadKml {
    public static void main(String[] args) throws JAXBException {
        String path = "./data/wpmz/waylines.wpml";
        Kml kml = readKmlContent(path);
        System.out.println(XmlUtil.objectToXML(kml));
    }

    public static Kml readKmlContent(String kmlPath) throws JAXBException {
        File kmlFile = new File(kmlPath);
        if (!kmlFile.exists()) {
            return null;
        }
        return XmlUtil.xmlToBean(kmlFile, Kml.class);
    }
}
