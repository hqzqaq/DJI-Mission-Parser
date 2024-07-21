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
 * 航点云台航向参数
 *
 * @author hqzqaq
 * @ClassName WaypointGimbalHeadingParam
 * @createTime 2023年03月23日 20:37:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WaypointGimbalHeadingParam implements Serializable {

    private static final long serialVersionUID = -48631388826075554L;

    @XmlElement(name="waypointGimbalPitchAngle",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointGimbalPitchAngle")
    private Integer waypointGimbalPitchAngle;

    @XmlElement(name="waypointGimbalYawAngle",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointGimbalYawAngle")
    private Integer waypointGimbalYawAngle;

    @XmlTransient
    public Integer getWaypointGimbalPitchAngle() {
        return waypointGimbalPitchAngle;
    }

    public void setWaypointGimbalPitchAngle(Integer waypointGimbalPitchAngle) {
        this.waypointGimbalPitchAngle = waypointGimbalPitchAngle;
    }

    @XmlTransient
    public Integer getWaypointGimbalYawAngle() {
        return waypointGimbalYawAngle;
    }

    public void setWaypointGimbalYawAngle(Integer waypointGimbalYawAngle) {
        this.waypointGimbalYawAngle = waypointGimbalYawAngle;
    }
}
