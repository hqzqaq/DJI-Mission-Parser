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
 * 动作参数
 *
 * @author hqzqaq
 * @ClassName ActionActuatorFuncParam
 * @createTime 2023年03月20日 20:38:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ActionActuatorFuncParam implements Serializable {

    private static final long serialVersionUID = -7683913009883751516L;

    /**
     * 拍摄照片文件后缀
     * 为生成媒体文件命名时将额外附带该后缀。
     */
    @XmlElement(name = "fileSuffix",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("fileSuffix")
    private String fileSuffix;

    /**
     * 负载挂载位置
     * 0：飞行器1号挂载位置。M300 RTK机型，对应机身左前方。其它机型，对应主云台。
     * 1：飞行器2号挂载位置。M300 RTK机型，对应机身右前方。
     * 2：飞行器3号挂载位置。M300 RTK机型，对应机身上方。
     */
    @XmlElement(name = "gimbalRotateSpeedEnable",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalRotateSpeedEnable")
    private Integer payloadPositionIndex;

    /**
     * zoom: 存储变焦镜头拍摄照片
     * wide: 存储广角镜头拍摄照片
     * ir: 存储红外镜头拍摄照片
     * narrow_band: 存储窄带镜头拍摄照片
     * 注：存储多个镜头照片，格式如“<payloadLensIndex>wide,ir,narrow_band</payloadLensIndex>”表示同时使用广角、红外和窄带镜头
     */
    @XmlElement(name = "payloadLensIndex",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("payloadLensIndex")
    private String payloadLensIndex;

    /**
     * 是否使用全局存储类型
     * 0：不使用全局设置
     * 1：使用全局设置
     */
    @XmlElement(name = "useGlobalPayloadLensIndex",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("useGlobalPayloadLensIndex")
    private Integer useGlobalPayloadLensIndex;

    /**
     * 云台偏航角转动坐标系
     * north：相对地理北
     */
    @XmlElement(name = "gimbalHeadingYawBase",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalHeadingYawBase")
    private String gimbalHeadingYawBase;

    /**
     * 云台转动模式
     * relativeAngle：相对角度
     * absoluteAngle：绝对角度
     */
    @XmlElement(name = "gimbalRotateMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalRotateMode")
    private String gimbalRotateMode;

    /**
     * 是否使能云台Pitch转动
     * 0：不使能
     * 1：使能
     */
    @XmlElement(name = "gimbalPitchRotateEnable",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalPitchRotateEnable")
    private Integer gimbalPitchRotateEnable;

    /**
     * 云台Pitch转动角度
     * * 注：不同云台可转动范围不同
     */
    @XmlElement(name = "gimbalPitchRotateAngle",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalPitchRotateAngle")
    private Double gimbalPitchRotateAngle;

    /**
     * 是否使能云台Roll转动
     * 0：不使能
     * 1：使能
     */
    @XmlElement(name = "gimbalRollRotateEnable",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalRollRotateEnable")
    private Integer gimbalRollRotateEnable;

    /**
     * 云台Roll转动角度
     * * 注：不同云台可转动范围不同
     */
    @XmlElement(name = "gimbalRollRotateAngle",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalRollRotateAngle")
    private Double gimbalRollRotateAngle;

    /**
     * 是否使能云台Yaw转动
     * 0：不使能
     * 1：使能
     */
    @XmlElement(name = "gimbalYawRotateEnable",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalYawRotateEnable")
    private Integer gimbalYawRotateEnable;

    /**
     * 云台Yaw转动角度
     * * 注：不同云台可转动范围不同
     */
    @XmlElement(name = "gimbalYawRotateAngle",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalYawRotateAngle")
    private Double gimbalYawRotateAngle;

    /**
     * 是否使能云台转动时间
     * 0：不使能
     * 1：使能
     */
    @XmlElement(name = "gimbalRotateTimeEnable",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalRotateTimeEnable")
    private Integer gimbalRotateTimeEnable;

    /**
     * 云台完成转动用时
     * 单位：s
     */
    @XmlElement(name = "gimbalRotateTime",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("gimbalRotateTime")
    private Double gimbalRotateTime;


    /**
     * 航点动作 focus
     * 是否点对焦，0：区域对焦 1：点对焦
     */
    @XmlElement(name = "isPointFocus",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("isPointFocus")
    private Boolean isPointFocus;

    /**
     * 航点动作 focus
     * 对焦点位置
     * [0, 1]
     * 注：对焦点或对焦区域左上角在画面的X轴（宽）坐标。0为最左侧，1为最右侧。
     */
    @XmlElement(name = "focusX",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("focusX")
    private Float focusX;

    /**
     * 航点动作 focus
     * 对焦点位置
     * [0, 1]
     * 注：对焦点或对焦区域左上角在画面的X轴（宽）坐标。0为最左侧，1为最右侧。
     */
    @XmlElement(name = "focusY",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("focusY")
    private Float focusY;

    /**
     * 航点动作 focus
     * [0, 1]
     * 注：对焦区域大小占画面整体的比例，此为宽度比
     * 注：当且仅当“isPointFocus”为“0”（即区域对焦）时必需。
     */
    @XmlElement(name = "focusRegionWidth",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("focusRegionWidth")
    private Float focusRegionWidth;

    /**
     * 航点动作 focus
     * 对焦区域高度比
     * [0, 1]
     * 注：对焦区域大小占画面整体的比例，此为高度比
     * 注：当且仅当“isPointFocus”为“0”（即区域对焦）时必需。
     */
    @XmlElement(name = "focusRegionHeight",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("focusRegionHeight")
    private Float focusRegionHeight;

    /**
     * 航点动作 focus
     * 是否无穷远对焦,0: 非无穷远对焦 1: 无穷远对焦
     */
    @XmlElement(name = "isInfiniteFocus",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("isInfiniteFocus")
    private Boolean isInfiniteFocus;

    /**
     * 航点动作 zoom
     * 变焦焦距
     * mm
     * > 0
     */
    @XmlElement(name = "focalLength",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("focalLength")
    private Integer focalLength;

    /**
     * 航点动作 customDirName
     * 新文件夹的名称
     */
    @XmlElement(name = "directoryName",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("directoryName")
    private String directoryName;

    /**
     * 航点动作 rotateYaw
     * 飞行器目标偏航角（相对于地理北）
     * [-180, 180]
     * 注：飞行器旋转至该目标偏航角。0°为正北方向，90°为正东方向，-90°为正西方向，-180°/180°为正南方向。
     */
    @XmlElement(name = "rotateYawAircraftHeading",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("rotateYawAircraftHeading")
    private Float aircraftHeading;

    /**
     * 航点动作 rotateYaw
     * 飞行器偏航角转动模式
     * clockwise：顺时针旋转
     * counterClockwise：逆时针旋转
     */
    @XmlElement(name = "rotateYawAircraftHeadingMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("rotateYawAircraftHeadingMode")
    private String aircraftPathMode;

    /**
     * 航点动作 hover
     * 飞行器悬停等待时间
     * 单位s >0
     */
    @XmlElement(name = "hoverTime",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("hoverTime")
    private Float hoverTime;

    @XmlTransient
    public String getGimbalHeadingYawBase() {
        return gimbalHeadingYawBase;
    }

    public void setGimbalHeadingYawBase(String gimbalHeadingYawBase) {
        this.gimbalHeadingYawBase = gimbalHeadingYawBase;
    }

    @XmlTransient
    public String getGimbalRotateMode() {
        return gimbalRotateMode;
    }

    public void setGimbalRotateMode(String gimbalRotateMode) {
        this.gimbalRotateMode = gimbalRotateMode;
    }

    @XmlTransient
    public Integer getGimbalPitchRotateEnable() {
        return gimbalPitchRotateEnable;
    }

    public void setGimbalPitchRotateEnable(Integer gimbalPitchRotateEnable) {
        this.gimbalPitchRotateEnable = gimbalPitchRotateEnable;
    }

    @XmlTransient
    public Integer getGimbalRollRotateEnable() {
        return gimbalRollRotateEnable;
    }

    public void setGimbalRollRotateEnable(Integer gimbalRollRotateEnable) {
        this.gimbalRollRotateEnable = gimbalRollRotateEnable;
    }

    @XmlTransient
    public Integer getGimbalYawRotateEnable() {
        return gimbalYawRotateEnable;
    }

    public void setGimbalYawRotateEnable(Integer gimbalYawRotateEnable) {
        this.gimbalYawRotateEnable = gimbalYawRotateEnable;
    }

    @XmlTransient
    public Integer getGimbalRotateTimeEnable() {
        return gimbalRotateTimeEnable;
    }

    public void setGimbalRotateTimeEnable(Integer gimbalRotateTimeEnable) {
        this.gimbalRotateTimeEnable = gimbalRotateTimeEnable;
    }

    @XmlTransient
    public Integer getPayloadPositionIndex() {
        return payloadPositionIndex;
    }

    public void setPayloadPositionIndex(Integer payloadPositionIndex) {
        this.payloadPositionIndex = payloadPositionIndex;
    }

    @XmlTransient
    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    @XmlTransient
    public Integer getUseGlobalPayloadLensIndex() {
        return useGlobalPayloadLensIndex;
    }

    public void setUseGlobalPayloadLensIndex(Integer useGlobalPayloadLensIndex) {
        this.useGlobalPayloadLensIndex = useGlobalPayloadLensIndex;
    }

    @XmlTransient
    public String getPayloadLensIndex() {
        return payloadLensIndex;
    }

    public void setPayloadLensIndex(String payloadLensIndex) {
        this.payloadLensIndex = payloadLensIndex;
    }

    @XmlTransient
    public Double getGimbalPitchRotateAngle() {
        return gimbalPitchRotateAngle;
    }

    public void setGimbalPitchRotateAngle(Double gimbalPitchRotateAngle) {
        this.gimbalPitchRotateAngle = gimbalPitchRotateAngle;
    }

    @XmlTransient
    public Double getGimbalRollRotateAngle() {
        return gimbalRollRotateAngle;
    }

    public void setGimbalRollRotateAngle(Double gimbalRollRotateAngle) {
        this.gimbalRollRotateAngle = gimbalRollRotateAngle;
    }

    @XmlTransient
    public Double getGimbalYawRotateAngle() {
        return gimbalYawRotateAngle;
    }

    public void setGimbalYawRotateAngle(Double gimbalYawRotateAngle) {
        this.gimbalYawRotateAngle = gimbalYawRotateAngle;
    }

    @XmlTransient
    public Double getGimbalRotateTime() {
        return gimbalRotateTime;
    }

    public void setGimbalRotateTime(Double gimbalRotateTime) {
        this.gimbalRotateTime = gimbalRotateTime;
    }

    @XmlTransient
    public Boolean getPointFocus() {
        return isPointFocus;
    }

    public void setPointFocus(Boolean pointFocus) {
        isPointFocus = pointFocus;
    }
    @XmlTransient
    public Float getFocusX() {
        return focusX;
    }

    public void setFocusX(Float focusX) {
        this.focusX = focusX;
    }
    @XmlTransient
    public Float getFocusY() {
        return focusY;
    }

    public void setFocusY(Float focusY) {
        this.focusY = focusY;
    }

    @XmlTransient
    public Float getFocusRegionWidth() {
        return focusRegionWidth;
    }

    public void setFocusRegionWidth(Float focusRegionWidth) {
        this.focusRegionWidth = focusRegionWidth;
    }

    @XmlTransient
    public Float getFocusRegionHeight() {
        return focusRegionHeight;
    }

    public void setFocusRegionHeight(Float focusRegionHeight) {
        this.focusRegionHeight = focusRegionHeight;
    }

    @XmlTransient
    public Boolean getInfiniteFocus() {
        return isInfiniteFocus;
    }

    public void setInfiniteFocus(Boolean infiniteFocus) {
        isInfiniteFocus = infiniteFocus;
    }

    @XmlTransient
    public Integer getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    @XmlTransient
    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    @XmlTransient
    public Float getAircraftHeading() {
        return aircraftHeading;
    }

    public void setAircraftHeading(Float aircraftHeading) {
        this.aircraftHeading = aircraftHeading;
    }

    @XmlTransient
    public String getAircraftPathMode() {
        return aircraftPathMode;
    }

    public void setAircraftPathMode(String aircraftPathMode) {
        this.aircraftPathMode = aircraftPathMode;
    }

    @XmlTransient
    public Float getHoverTime() {
        return hoverTime;
    }

    public void setHoverTime(Float hoverTime) {
        this.hoverTime = hoverTime;
    }
}
