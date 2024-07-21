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
 * 负载信息
 *
 * @author hqzqaq
 * @ClassName PayloadInfo
 * @createTime 2023年03月20日 15:04:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PayloadInfo implements Serializable {


    private static final long serialVersionUID = 5843520648413596989L;

    /**
     * 负载机型主类型
     * 43（H20T）,
     * 50（P1）,
     * 52（M30双光相机）,
     * 53（M30T三光相机）,
     * 61（H20N）,
     * 90742（L1）
     * 66（Mavic 3E 相机）
     * 67（Mavic 3T 相机）
     * 68（Mavic 3M 相机）
     * 65534（PSDK 负载）
     */
    @XmlElement(name="payloadEnumValue",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("payloadEnumValue")
    private Integer payloadEnumValue;

    /**
     * 负载机型子类型
     * ZENMUSE_P1：
     * 0（LENS_24mm）,
     * 1（LENS_35mm）,
     * 2（LENS_50mm）
     */
    @XmlElement(name="payloadSubEnumValue",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("payloadSubEnumValue")
    private Integer payloadSubEnumValue;

    /**
     * 负载挂载位置
     * 0：飞行器1号挂载位置。M300 RTK机型，对应机身左前方。其它机型，对应主云台。
     * 1：飞行器2号挂载位置。M300 RTK机型，对应机身右前方。
     * 2：飞行器3号挂载位置。M300 RTK机型，对应机身上方。
     */
    @XmlElement(name="payloadPositionIndex",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("payloadPositionIndex")
    private Integer payloadPositionIndex;
    @XmlTransient
    public Integer getPayloadEnumValue() {
        return payloadEnumValue;
    }

    public void setPayloadEnumValue(Integer payloadEnumValue) {
        this.payloadEnumValue = payloadEnumValue;
    }

    @XmlTransient
    public Integer getPayloadSubEnumValue() {
        return payloadSubEnumValue;
    }

    public void setPayloadSubEnumValue(Integer payloadSubEnumValue) {
        this.payloadSubEnumValue = payloadSubEnumValue;
    }
    @XmlTransient
    public Integer getPayloadPositionIndex() {
        return payloadPositionIndex;
    }

    public void setPayloadPositionIndex(Integer payloadPositionIndex) {
        this.payloadPositionIndex = payloadPositionIndex;
    }


}
