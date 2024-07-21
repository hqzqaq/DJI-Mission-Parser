package cn.beidou.scnu.dji;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 航线文件转换类
 *
 * @author hqzqaq
 * @ClassName Kml
 * @createTime 2023年03月20日 14:55:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@XmlRootElement(name = "kml", namespace = "http://www.opengis.net/kml/2.2")
@XmlAccessorType(XmlAccessType.FIELD)
public class Kml implements Serializable {
    private static final long serialVersionUID = 2971694624628931590L;

    @XmlElement(name = "Document")
    private Document document;

    @XmlTransient
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document documet) {
        this.document = documet;
    }

}
