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
 * 全局航点航行参数
 *
 * @author hqzqaq
 * @ClassName GlobalWaypointHeadingParam
 * @createTime 2023年03月20日 15:15:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GlobalWaypointHeadingParam implements Serializable {
    private static final long serialVersionUID = -1086733382202237536L;
    /**
     * 飞行器偏航角模式
     * followWayline：沿航线方向。飞行器机头沿着航线方向飞至下一航点
     * manually：手动控制。飞行器在飞至下一航点的过程中，用户可以手动控制飞行器机头朝向
     * fixed：锁定当前偏航角。飞行器机头保持执行完航点动作后的飞行器偏航角飞至下一航点
     * smoothTransition：自定义。通过“waypointHeadingAngle”给定某航点的目标偏航角，并在航段飞行过程中均匀过渡至下一航点的目标偏航角。
     */
    @XmlElement(name="waypointHeadingMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointHeadingMode")
    private String	waypointHeadingMode;

    /**
     * 航点航向poi点
     */
    @XmlElement(name="waypointPoiPoint",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointPoiPoint")
    private String	waypointPoiPoint;

    /**
     * 飞行器偏航角度
     * 给定某航点的目标偏航角，并在航段飞行过程中均匀过渡至下一航点的目标偏航角。
     */
    @XmlElement(name="waypointHeadingAngle",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointHeadingAngle")
    private Integer	waypointHeadingAngle;

    /**
     * 飞行器偏航角转动方向
     * clockwise：顺时针旋转飞行器偏航角
     * counterClockwise：逆时针旋转飞行器偏航角
     * followBadArc：沿最短路径旋转飞行器偏航角
     */
    @XmlElement(name="waypointHeadingPathMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointHeadingPathMode")
    private String waypointHeadingPathMode;

    /**
     * 途经点 航向 Poi索引
     */
    @XmlElement(name="waypointHeadingPoiIndex",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointHeadingPoiIndex")
    private String	waypointHeadingPoiIndex;

    @XmlTransient
    public String getWaypointHeadingMode() {
        return waypointHeadingMode;
    }

    public void setWaypointHeadingMode(String waypointHeadingMode) {
        this.waypointHeadingMode = waypointHeadingMode;
    }
    @XmlTransient
    public Integer getWaypointHeadingAngle() {
        return waypointHeadingAngle;
    }

    public void setWaypointHeadingAngle(Integer waypointHeadingAngle) {
        this.waypointHeadingAngle = waypointHeadingAngle;
    }
    @XmlTransient
    public String getWaypointPoiPoint() {
        return waypointPoiPoint;
    }

    public void setWaypointPoiPoint(String waypointPoiPoint) {
        this.waypointPoiPoint = waypointPoiPoint;
    }
    @XmlTransient
    public String getWaypointHeadingPoiIndex() {
        return waypointHeadingPoiIndex;
    }

    public void setWaypointHeadingPoiIndex(String waypointHeadingPoiIndex) {
        this.waypointHeadingPoiIndex = waypointHeadingPoiIndex;
    }

    @XmlTransient
    public String getWaypointHeadingPathMode() {
        return waypointHeadingPathMode;
    }

    public void setWaypointHeadingPathMode(String waypointHeadingPathMode) {
        this.waypointHeadingPathMode = waypointHeadingPathMode;
    }
}
