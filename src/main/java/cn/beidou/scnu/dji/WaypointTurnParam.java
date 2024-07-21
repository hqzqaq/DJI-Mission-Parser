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
 * 航点类型（航点转弯模式）
 *
 * @author hqzqaq
 * @ClassName WaypointTurnParam
 * @createTime 2023年03月20日 22:22:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WaypointTurnParam implements Serializable {
    private static final long serialVersionUID = 5458676318626030319L;

    /**
     * 航点类型（航点转弯模式）
     * coordinateTurn：协调转弯，不过点，提前转弯
     * toPointAndStopWithDiscontinuityCurvature：直线飞行，飞行器到点停
     * toPointAndStopWithContinuityCurvature：曲线飞行，飞行器到点停
     * toPointAndPassWithContinuityCurvature：曲线飞行，飞行器过点不停
     */
    @XmlElement(name="waypointTurnMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointTurnMode")
    private String waypointTurnMode;

    /**
     * 航点转弯截距
     * (0, 航段最大长度]
     * * 注：两航点间航段长度必需大于两航点转弯截距之和。此元素定义了飞行器在距离该航点若干米前，提前多少距离转弯。
     * 必须元素
     * * 注：当且仅当以下两种情况下必需“waypointTurnMode”为“coordinateTurn”“waypointTurnMode”为“toPointAndPassWithContinuityCurvature”，且“useStraightLine”为“1”	M300 RTK，M30/M30T，M3E/M3T/M3M
     */
    @XmlElement(name="waypointTurnDampingDist",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointTurnDampingDist")
    private Double waypointTurnDampingDist;

    @XmlTransient
    public String getWaypointTurnMode() {
        return waypointTurnMode;
    }

    public void setWaypointTurnMode(String waypointTurnMode) {
        this.waypointTurnMode = waypointTurnMode;
    }

    @XmlTransient
    public Double getWaypointTurnDampingDist() {
        return waypointTurnDampingDist;
    }

    public void setWaypointTurnDampingDist(Double waypointTurnDampingDist) {
        this.waypointTurnDampingDist = waypointTurnDampingDist;
    }
}
