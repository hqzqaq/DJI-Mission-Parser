package cn.beidou.scnu.dji;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * 航点信息
 *
 * @author hqzqaq
 * @ClassName Placemark
 * @createTime 2023年03月20日 15:16:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Placemark implements Serializable {
    private static final long serialVersionUID = 217571107479115377L;
    /**
     * 航点经纬度<经度,纬度>
     * * 注：此处格式如“<Point> <coordinates> 经度,纬度 </coordinates> </Point>”
     * [-90,90],[-180,180]
     */
    @XmlElement(name = "Point")
    @JsonProperty("Point")
    private Point point;
    /**
     * 航点序号
     * * 注：在一条航线内该ID唯一。该序号必须从0开始单调连续递增。
     * [0, 65535]
     */
    @XmlElement(name = "index",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("index")
    private Integer index;

    /**
     * 航点高度（WGS84椭球高度）
     * * 注：该元素与“height”配合使用，二者是同一位置不同高程参考平面的表达。
     * 必需元素
     * 注：当且仅当“useGlobalHeight”为“0”时必需
     */
    @XmlElement(name = "ellipsoidHeight",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("ellipsoidHeight")
    private Double ellipsoidHeight;

    /**
     * 航点高度（EGM96海拔高度/相对起飞点高度/AGL相对地面高度）
     * * 注：该元素与“ellipsoidHeight”配合使用，二者是同一位置不同高程参考平面的表达。
     * 必需元素
     * * 注：当且仅当“useGlobalHeight”为“0”时必需
     */
    @XmlElement(name = "height",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("height")
    private Double height;

    /**
     * 执行高度
     */
    @XmlElement(name = "executeHeight",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("executeHeight")
    private Double executeHeight;

    /**
     * 航点飞行速度
     * [1,15]
     * 必需元素
     * * 注：当且仅当“useGlobalSpeed”为“0”时必需
     */
    @XmlElement(name = "waypointSpeed",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointSpeed")
    private Double waypointSpeed;

    @XmlElement(name = "waypointHeadingParam",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointHeadingParam")
    private WaypointHeadingParam waypointHeadingParam;

    /**
     * 航点类型（航点转弯模式）
     * 必需元素
     * * 注：当且仅当“useGlobalTurnParam”为“0”时必需
     */
    @XmlElement(name = "waypointTurnParam",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointTurnParam")
    private WaypointTurnParam waypointTurnParam;

    /**
     * 是否使用全局高度
     * 0：不使用全局设置
     * 1：使用全局设置
     */
    @XmlElement(name = "useGlobalHeight",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("useGlobalHeight")
    private Integer useGlobalHeight;

    /**
     * 是否使用全局飞行速度
     * * 注：此处的全局飞行速度即“autoFlightSpeed”
     * 0：不使用全局设置
     * 1：使用全局设置
     */
    @XmlElement(name = "useGlobalSpeed",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("useGlobalSpeed")
    private Integer useGlobalSpeed;

    /**
     * 是否使用全局偏航角模式参数
     * 0：不使用全局设置
     * 1：使用全局设置
     */
    @XmlElement(name = "useGlobalHeadingParam",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("useGlobalHeadingParam")
    private Integer useGlobalHeadingParam;

    /**
     * 是否使用全局航点类型（全局航点转弯模式）
     * 0：不使用全局设置
     * 1：使用全局设置
     */
    @XmlElement(name = "useGlobalTurnParam",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("useGlobalTurnParam")
    private Integer useGlobalTurnParam;

    /**
     * 航点云台俯仰角
     * 对应机型云台可转动范围
     * 必需元素
     * * 注：当且仅当“gimbalPitchMode”为“usePointSetting”时必需。
     */
    @XmlElement(name = "gimbalPitchAngle",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalPitchAngle")
    private Double gimbalPitchAngle;

    /**
     * 该航段是否贴合直线
     * 0：航段轨迹全程为曲线
     * 1：航段轨迹尽量贴合两点连线
     * 必需元素
     * * 注：当且仅当“waypointTurnParam”内"waypointTurnMode"被设置为“toPointAndStopWithContinuityCurvature”或“toPointAndPassWithContinuityCurvature”时必需。如果此元素被设置，则局部定义会覆盖全局定义。
     */
    @XmlElement(name = "useStraightLine",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("useStraightLine")
    private Integer useStraightLine;

    /**
     * 航点动作
     */
    @XmlElement(name = "actionGroup",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("actionGroup")
    private List<ActionGroup> actionGroup;

    @XmlElement(name = "waypointGimbalHeadingParam",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waypointGimbalHeadingParam")
    private WaypointGimbalHeadingParam waypointGimbalHeadingParam;

    @XmlTransient
    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    @XmlTransient
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    @XmlTransient
    public Double getEllipsoidHeight() {
        return ellipsoidHeight;
    }

    public void setEllipsoidHeight(Double ellipsoidHeight) {
        this.ellipsoidHeight = ellipsoidHeight;
    }
    @XmlTransient
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
    @XmlTransient
    public Double getWaypointSpeed() {
        return waypointSpeed;
    }

    public void setWaypointSpeed(Double waypointSpeed) {
        this.waypointSpeed = waypointSpeed;
    }
    @XmlTransient
    public WaypointHeadingParam getWaypointHeadingParam() {
        return waypointHeadingParam;
    }

    public void setWaypointHeadingParam(WaypointHeadingParam waypointHeadingParam) {
        this.waypointHeadingParam = waypointHeadingParam;
    }
    @XmlTransient
    public WaypointTurnParam getWaypointTurnParam() {
        return waypointTurnParam;
    }

    public void setWaypointTurnParam(WaypointTurnParam waypointTurnParam) {
        this.waypointTurnParam = waypointTurnParam;
    }
    @XmlTransient
    public Integer getUseGlobalHeight() {
        return useGlobalHeight;
    }

    public void setUseGlobalHeight(Integer useGlobalHeight) {
        this.useGlobalHeight = useGlobalHeight;
    }
    @XmlTransient
    public Integer getUseGlobalSpeed() {
        return useGlobalSpeed;
    }

    public void setUseGlobalSpeed(Integer useGlobalSpeed) {
        this.useGlobalSpeed = useGlobalSpeed;
    }
    @XmlTransient
    public Integer getUseGlobalHeadingParam() {
        return useGlobalHeadingParam;
    }

    public void setUseGlobalHeadingParam(Integer useGlobalHeadingParam) {
        this.useGlobalHeadingParam = useGlobalHeadingParam;
    }
    @XmlTransient
    public Integer getUseGlobalTurnParam() {
        return useGlobalTurnParam;
    }

    public void setUseGlobalTurnParam(Integer useGlobalTurnParam) {
        this.useGlobalTurnParam = useGlobalTurnParam;
    }
    @XmlTransient
    public Double getGimbalPitchAngle() {
        return gimbalPitchAngle;
    }

    public void setGimbalPitchAngle(Double gimbalPitchAngle) {
        this.gimbalPitchAngle = gimbalPitchAngle;
    }
    @XmlTransient
    public Integer getUseStraightLine() {
        return useStraightLine;
    }

    public void setUseStraightLine(Integer useStraightLine) {
        this.useStraightLine = useStraightLine;
    }

    @XmlTransient
    public Double getExecuteHeight() {
        return executeHeight;
    }

    public void setExecuteHeight(Double executeHeight) {
        this.executeHeight = executeHeight;
    }

    @XmlTransient
    public List<ActionGroup> getActionGroup() {
        return actionGroup;
    }

    public void setActionGroup(List<ActionGroup> actionGroup) {
        this.actionGroup = actionGroup;
    }

    @XmlTransient
    public WaypointGimbalHeadingParam getWaypointGimbalHeadingParam() {
        return waypointGimbalHeadingParam;
    }

    public void setWaypointGimbalHeadingParam(WaypointGimbalHeadingParam waypointGimbalHeadingParam) {
        this.waypointGimbalHeadingParam = waypointGimbalHeadingParam;
    }
}
