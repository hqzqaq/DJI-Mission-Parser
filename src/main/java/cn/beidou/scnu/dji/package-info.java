@javax.xml.bind.annotation.XmlSchema(
        namespace = "http://www.opengis.net/kml/2.2",
        elementFormDefault = XmlNsForm.QUALIFIED,
        attributeFormDefault = XmlNsForm.UNQUALIFIED,
        xmlns = {
                @XmlNs(prefix = "", namespaceURI = "http://www.opengis.net/kml/2.2"),
                @XmlNs(prefix = "wpml", namespaceURI = "http://www.dji.com/wpmz/1.0.3")
        }
)
package cn.beidou.scnu.dji;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;