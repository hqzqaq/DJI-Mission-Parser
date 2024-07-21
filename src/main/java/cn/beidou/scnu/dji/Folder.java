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
 * 无人机设置
 *
 * @author hqzqaq
 * @ClassName Folder
 * @createTime 2023年03月20日 15:05:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Folder implements Serializable {
    private static final long serialVersionUID = 539561806804835411L;

    /**
     * 模板ID
     * * 注：在一个kmz文件内该ID唯一。建议从0开始单调连续递增。在template.kml和waylines.wpml文件中，将使用该id将模板与所生成的可执行航线进行关联。
     * [0, 65535]
     */
    @XmlElement(name = "templateId", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("templateId")
    private Integer templateId;

    /**
     * 预定义模板类型
     * * 注：模板为用户提供了快速生成航线的方案。用户填充模板元素，再导入大疆支持客户端（如DJI Pilot），即可快速生成可执行的测绘/巡检航线。
     * waypoint：航点飞行
     * mapping2d：建图航拍
     * mapping3d：倾斜摄影
     * mappingStrip：航带飞行
     */
    @XmlElement(name = "templateType", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("templateType")
    private String templateType;

    /**
     * 执行高度模式
     * * 注：该元素仅在waylines.wpml中使用。
     * WGS84：椭球高模式
     * relativeToStartPoint：相对起飞点高度模式
     */
    @XmlElement(name = "executeHeightMode", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("executeHeightMode")
    private String executeHeightMode;

    @XmlElement(name = "waylineId", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waylineId")
    private Integer waylineId;

    /**
     * 坐标系参数
     */
    @XmlElement(name = "waylineCoordinateSysParam", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("waylineCoordinateSysParam")
    private WaylineCoordinateSysParam waylineCoordinateSysParam;

    /**
     * 全局航线飞行速度
     */
    @XmlElement(name = "autoFlightSpeed", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("autoFlightSpeed")
    private Double autoFlightSpeed;

    /**
     * 全局航线高度（相对起飞点高度）
     */
    @XmlElement(name = "globalHeight", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("globalHeight")
    private Double globalHeight;

    /**
     * 是否开启标定飞行
     * * 注：仅适用于M300 RTK与L1机型
     * 0：不开启
     * 1：开启，航线中自动进行惯导标定，保证模型精度。航线收尾会进行三次加减速飞行，航线拐弯处自动外扩进行加减速飞行。航线过长会均匀插入加减速飞行，每次标定后飞行时间不会超过100s。
     */
    @XmlElement(name = "caliFlightEnable", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("caliFlightEnable")
    private Integer caliFlightEnable = 0;
    /**
     * 全局航线高度（相对起飞点高度）
     * manual：手动控制。飞行器从一个航点飞向下一个航点的过程中，支持用户手动控制云台的俯仰角度；若无用户控制，则保持飞离航点时的云台俯仰角度。
     * usePointSetting：依照每个航点设置。飞行器从一个航点飞向下一个航点的过程中，云台俯仰角均匀过渡至下一个航点的俯仰角。
     */
    @XmlElement(name = "gimbalPitchMode", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalPitchMode")
    private String gimbalPitchMode;

    /**
     * 全局偏航角模式参数
     */
    @XmlElement(name = "globalWaypointHeadingParam", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("globalWaypointHeadingParam")
    private GlobalWaypointHeadingParam globalWaypointHeadingParam;

    /**
     * 全局航点类型（全局航点转弯模式）
     * coordinateTurn：协调转弯，不过点，提前转弯
     * toPointAndStopWithDiscontinuityCurvature：直线飞行，飞行器到点停
     * toPointAndStopWithContinuityCurvature：曲线飞行，飞行器到点停
     * toPointAndPassWithContinuityCurvature：曲线飞行，飞行器过点不停
     */
    @XmlElement(name = "globalWaypointTurnMode", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("globalWaypointTurnMode")
    private String globalWaypointTurnMode;

    /**
     * 全局航段轨迹是否尽量贴合直线
     * 0：航段轨迹全程为曲线
     * 1：航段轨迹尽量贴合两点连线
     */
    @XmlElement(name = "globalUseStraightLine", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("globalUseStraightLine")
    private Integer globalUseStraightLine;

    /**
     * 飞行首航点执行的动作
     */
    @XmlElement(name = "startActionGroup", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("startActionGroup")
    private ActionGroup startActionGroup;

    /**
     * 航点信息（包括航点经纬度和高度等）
     */
    @XmlElement(name = "Placemark")
    private List<Placemark> Placemark;

    /**
     * 负载设置
     */
    @XmlElement(name = "payloadParam", namespace = "http://www.dji.com/wpmz/1.0.3")
    private PayloadParam payloadParam;

    @XmlTransient
    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    @XmlTransient
    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @XmlTransient
    public WaylineCoordinateSysParam getWaylineCoordinateSysParam() {
        return waylineCoordinateSysParam;
    }

    public void setWaylineCoordinateSysParam(WaylineCoordinateSysParam waylineCoordinateSysParam) {
        this.waylineCoordinateSysParam = waylineCoordinateSysParam;
    }

    @XmlTransient
    public String getGimbalPitchMode() {
        return gimbalPitchMode;
    }

    public void setGimbalPitchMode(String gimbalPitchMode) {
        this.gimbalPitchMode = gimbalPitchMode;
    }

    @XmlTransient
    public GlobalWaypointHeadingParam getGlobalWaypointHeadingParam() {
        return globalWaypointHeadingParam;
    }

    public void setGlobalWaypointHeadingParam(GlobalWaypointHeadingParam globalWaypointHeadingParam) {
        this.globalWaypointHeadingParam = globalWaypointHeadingParam;
    }

    @XmlTransient
    public String getGlobalWaypointTurnMode() {
        return globalWaypointTurnMode;
    }

    public void setGlobalWaypointTurnMode(String globalWaypointTurnMode) {
        this.globalWaypointTurnMode = globalWaypointTurnMode;
    }

    @XmlTransient
    public Integer getGlobalUseStraightLine() {
        return globalUseStraightLine;
    }

    public void setGlobalUseStraightLine(Integer globalUseStraightLine) {
        this.globalUseStraightLine = globalUseStraightLine;
    }

    @XmlTransient
    public List<Placemark> getPlacemark() {
        return Placemark;
    }

    public void setPlacemark(List<Placemark> placemark) {
        Placemark = placemark;
    }

    @XmlTransient
    public PayloadParam getPayloadParam() {
        return payloadParam;
    }

    public void setPayloadParam(PayloadParam payloadParam) {
        this.payloadParam = payloadParam;
    }

    @XmlTransient
    public Double getAutoFlightSpeed() {
        return autoFlightSpeed;
    }

    public void setAutoFlightSpeed(Double autoFlightSpeed) {
        this.autoFlightSpeed = autoFlightSpeed;
    }

    @XmlTransient
    public Double getGlobalHeight() {
        return globalHeight;
    }

    public void setGlobalHeight(Double globalHeight) {
        this.globalHeight = globalHeight;
    }

    @XmlTransient
    public Integer getCaliFlightEnable() {
        return caliFlightEnable;
    }

    public void setCaliFlightEnable(Integer caliFlightEnable) {
        this.caliFlightEnable = caliFlightEnable;
    }

    @XmlTransient
    public String getExecuteHeightMode() {
        return executeHeightMode;
    }

    public void setExecuteHeightMode(String executeHeightMode) {
        this.executeHeightMode = executeHeightMode;
    }

    @XmlTransient
    public Integer getWaylineId() {
        return waylineId;
    }

    public void setWaylineId(Integer waylineId) {
        this.waylineId = waylineId;
    }

    @XmlTransient
    public ActionGroup getStartActionGroup() {
        return startActionGroup;
    }

    public void setStartActionGroup(ActionGroup startActionGroup) {
        this.startActionGroup = startActionGroup;
    }
}
