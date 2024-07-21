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
 * 飞行器信息
 *
 * @author hqzqaq
 * @ClassName DroneInfo
 * @createTime 2023年03月20日 15:02:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DroneInfo implements Serializable {

    private static final long serialVersionUID = -1487932814033621443L;
    /**
     * 飞行器机型主类型
     * 60（机型：M300 RTK）,
     * 67（机型：M30/M30T）,
     * 77（机型：M3E/M3T/M3M）
     */
    @XmlElement(name="droneEnumValue",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("droneEnumValue")
    private Integer droneEnumValue;

    /**
     * 飞行器机型主类型
     * 当“飞行器机型主类型”为“67（机型：M30/M30T）”时：
     * 0（机型：M30双光）,
     * 1（机型：M30T三光）
     * 当“飞行器机型主类型“为”77（机型：M3E/M3T/M3M）“时：
     * 0（机型：M3E）
     * 1（机型：M3T）
     * 2（机型：M3M）
     */
    @XmlElement(name="droneSubEnumValue",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("droneSubEnumValue")
    private Integer droneSubEnumValue;
    @XmlTransient
    public Integer getDroneEnumValue() {
        return droneEnumValue;
    }

    public void setDroneEnumValue(Integer droneEnumValue) {
        this.droneEnumValue = droneEnumValue;
    }
    @XmlTransient
    public Integer getDroneSubEnumValue() {
        return droneSubEnumValue;
    }

    public void setDroneSubEnumValue(Integer droneSubEnumValue) {
        this.droneSubEnumValue = droneSubEnumValue;
    }


}
