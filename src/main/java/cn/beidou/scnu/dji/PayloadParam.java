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
 * 负载参数
 *
 * @author hqzqaq
 * @ClassName PayloadParam
 * @createTime 2023年03月20日 15:16:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
//@JsonNaming
public class PayloadParam implements Serializable {

    private static final long serialVersionUID = 4537149390426264111L;
    /**
     * 负载挂载位置
     * 0：飞行器1号挂载位置。M300 RTK机型，对应机身左前方。其它机型，对应主云台。
     * 1：飞行器2号挂载位置。M300 RTK机型，对应机身右前方。
     * 2：飞行器3号挂载位置。M300 RTK机型，对应机身上方。
     */
    @XmlElement(name="payloadPositionIndex",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("payloadPositionIndex")
    private Integer	payloadPositionIndex;

    /**
     * 负载对焦模式
     * firstPoint：首个航点自动对焦
     * custom：标定对焦值对焦
     * 必需元素
     * * 注：当且仅当负载机型为“P1”时必需。
     */
    @XmlElement(name="focusMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("focusMode")
    private String focusMode;

    /**
     * 负载测光模式
     * average：全局测光
     * spot：点测光
     * 必需元素
     * * 注：当且仅当负载机型为“P1”时必需。
     */
    @XmlElement(name="meteringMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("meteringMode")
    private String	meteringMode;

    /**
     * 是否开启畸变矫正
     * 0：不开启
     * 1：开启
     * 必需元素
     * * 注：当且仅当负载机型为“P1”时必需。
     */
    @XmlElement(name="dewarpingEnable",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("dewarpingEnable")
    private Integer	dewarpingEnable;

    /**
     * 激光雷达回波模式
     * singleReturnStrongest：单回波
     * dualReturn：双回波
     * tripleReturn：三回波
     * 必需元素
     * * 注：当且仅当负载机型为“L1”时必需。
     */
    @XmlElement(name="returnMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("returnMode")
    private String	returnMode;

    /**
     * 负载采样率
     * 60000,
     * 80000,
     * 120000,
     * 160000,
     * 180000,
     * 240000
     * 必需元素
     * * 注：当且仅当负载机型为“L1”时必需。
     */
    @XmlElement(name="samplingRate",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("samplingRate")
    private Integer	samplingRate;

    /**
     * 负载扫描模式
     * repetitive：重复扫描
     * nonRepetitive：非重复扫描
     * 必需元素
     * * 注：当且仅当负载机型为“L1”时必需。
     */
    @XmlElement(name="scanningMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("scanningMode")
    private String	scanningMode;

    /**
     * 真彩上色
     * 0: 不上色
     * 1: 真彩上色
     * 必需元素
     * * 注：当且仅当负载机型为“L1”时必需。
     */
    @XmlElement(name="modelColoringEnable",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("modelColoringEnable")
    private Integer	modelColoringEnable;

    /**
     * 图片格式列表
     * wide：存储广角镜头照片
     * zoom：存储变焦镜头照片
     * ir：存储红外镜头照片
     * * 注：存储多个镜头照片，格式如“<payloadLensIndex>wide,ir</payloadLensIndex>”
     */
    @XmlElement(name="imageFormat",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("imageFormat")
    private String	imageFormat;

    @XmlTransient
    public String getMeteringMode() {
        return meteringMode;
    }

    public void setMeteringMode(String meteringMode) {
        this.meteringMode = meteringMode;
    }
   @XmlTransient
    public String getReturnMode() {
        return returnMode;
    }

    public void setReturnMode(String returnMode) {
        this.returnMode = returnMode;
    }
    @XmlTransient
    public String getScanningMode() {
        return scanningMode;
    }

    public void setScanningMode(String scanningMode) {
        this.scanningMode = scanningMode;
    }
    @XmlTransient
    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    @XmlTransient
    public Integer getPayloadPositionIndex() {
        return payloadPositionIndex;
    }

    public void setPayloadPositionIndex(Integer payloadPositionIndex) {
        this.payloadPositionIndex = payloadPositionIndex;
    }
    @XmlTransient
    public Integer getDewarpingEnable() {
        return dewarpingEnable;
    }

    public void setDewarpingEnable(Integer dewarpingEnable) {
        this.dewarpingEnable = dewarpingEnable;
    }
    @XmlTransient
    public Integer getSamplingRate() {
        return samplingRate;
    }

    public void setSamplingRate(Integer samplingRate) {
        this.samplingRate = samplingRate;
    }
    @XmlTransient
    public Integer getModelColoringEnable() {
        return modelColoringEnable;
    }

    public void setModelColoringEnable(Integer modelColoringEnable) {
        this.modelColoringEnable = modelColoringEnable;
    }

    @XmlTransient
    public String getFocusMode() {
        return focusMode;
    }

    public void setFocusMode(String focusMode) {
        this.focusMode = focusMode;
    }
}
