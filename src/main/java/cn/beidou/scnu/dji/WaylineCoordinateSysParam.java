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
 * 航线坐标系信息
 *
 * @author hqzqaq
 * @ClassName WaylineCoordinateSysParam
 * @createTime 2023年03月20日 15:07:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WaylineCoordinateSysParam implements Serializable {

    private static final long serialVersionUID = 6270413294287192654L;
    /**
     * 经纬度坐标系
     * WGS84：当前固定使用
     * WGS84坐标系
     */
    @XmlElement(name="coordinateMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("coordinateMode")
    private String coordinateMode = "WGS84";

    /**
     * 航点高程参考平面
     * EGM96：使用海拔高编辑
     * relativeToStartPoint：使用相对点的高度进行编辑
     * aboveGroundLevel：使用地形数据，AGL下编辑
     * realTimeFollowSurface: 使用实时仿地模式，仅支持M3E/M3T/M3M
     */
    @XmlElement(name="heightMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("heightMode")
    private String heightMode = "relativeToStartPoint";

    /**
     * 经纬度与高度数据源
     * GPS：位置数据采集来源为GPS/BDS/GLONASS/GALILEO等
     * RTKBaseStation：采集位置数据时，使用RTK基站进行差分定位
     * QianXun：采集位置数据时，使用千寻网络RTK进行查分定位
     * Custom：采集位置数据时，使用自定义网络RTK进行查分定位
     * 无，非必需元素
     * * 注：该元素仅用于标记位置数据来源，不影响实际航线执行。
     */
    @XmlElement(name="positioningType",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("positioningType")
    private String positioningType;

    /**
     * 飞行器离被摄面高度（相对地面高）
     * * 注：仅适用于模板类型mapping2d，mapping3d，mappingStrip
     * mapping2d是用于生成二维正射影像和数字表面模型（DSM）的模板
     * mapping3d是用于生成三维倾斜摄影模型（TDOM）的模板
     * mappingStrip是用于生成带状区域的二维或三维数据的模板
     * 用于计算拍照间距和GSD
     */
    @XmlElement(name="globalShootHeight",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("globalShootHeight")
    private Double globalShootHeight;

    /**
     * 是否开启仿地飞行
     * * 注：仅适用于模板类型mapping2d，mapping3d，mappingStrip
     * 0：不开启1：开启
     */
    @XmlElement(name="surfaceFollowModeEnable",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("surfaceFollowModeEnable")
    private Integer surfaceFollowModeEnable;

    /**
     * 仿地飞行离地高度（相对地面高）
     * * 注：仅适用于模板类型mapping2d，mapping3d，mappingStrip
     * 必需元素
     * * 注：当且仅当“surfaceFollowModeEnable”为“1”时必需
     */
    @XmlElement(name="surfaceRelativeHeight",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("surfaceRelativeHeight")
    private String surfaceRelativeHeight;

    @XmlTransient
    public String getCoordinateMode() {
        return coordinateMode;
    }

    public void setCoordinateMode(String coordinateMode) {
        this.coordinateMode = coordinateMode;
    }
    @XmlTransient
    public String getHeightMode() {
        return heightMode;
    }

    public void setHeightMode(String heightMode) {
        this.heightMode = heightMode;
    }
    @XmlTransient
    public String getPositioningType() {
        return positioningType;
    }

    public void setPositioningType(String positioningType) {
        this.positioningType = positioningType;
    }

    @XmlTransient
    public Double getGlobalShootHeight() {
        return globalShootHeight;
    }

    public void setGlobalShootHeight(Double globalShootHeight) {
        this.globalShootHeight = globalShootHeight;
    }

    @XmlTransient
    public Integer getSurfaceFollowModeEnable() {
        return surfaceFollowModeEnable;
    }

    public void setSurfaceFollowModeEnable(Integer surfaceFollowModeEnable) {
        this.surfaceFollowModeEnable = surfaceFollowModeEnable;
    }

    @XmlTransient
    public String getSurfaceRelativeHeight() {
        return surfaceRelativeHeight;
    }

    public void setSurfaceRelativeHeight(String surfaceRelativeHeight) {
        this.surfaceRelativeHeight = surfaceRelativeHeight;
    }


}
