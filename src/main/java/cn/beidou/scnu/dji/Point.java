package cn.beidou.scnu.dji;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * 经纬度
 *
 * @author hqzqaq
 * @ClassName Point
 * @createTime 2023年03月20日 15:15:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Point implements Serializable {
    private static final long serialVersionUID = 4605430762921929343L;
    /**
     * 经纬度，以逗号分隔
     */
    @XmlElement(name="coordinates")
    @JsonProperty("coordinates")
    private String	coordinates;

    @XmlTransient
    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
