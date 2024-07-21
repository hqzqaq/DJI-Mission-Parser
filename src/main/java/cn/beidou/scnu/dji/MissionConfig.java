package cn.beidou.scnu.dji;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 任务信息
 *
 * @author hqzqaq
 * @ClassName MissionConfig
 * @createTime 2023年03月20日 15:00:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MissionConfig implements java.io.Serializable{
    private static final long serialVersionUID = 4487519884834305799L;

    /**
     * 飞向首航点模式
     * safely：安全模式
     * （M300）飞行器起飞，上升至首航点高度，再平飞至首航点。如果首航点低于起飞点，则起飞后平飞至首航点上方再下降。
     * （M30）飞行器起飞，上升至首航点高度，再平飞至首航点。如果首航点低于“安全起飞高度”，则起飞至“安全起飞高度”后，平飞至首航点上方再下降。注意“安全起飞高度”仅在飞行器未起飞时生效。
     *
     * pointToPoint：倾斜飞行模式
     * （M300）飞行器起飞后，倾斜飞到首航点。
     * （M30）飞行器起飞至“安全起飞高度”，再倾斜爬升至首航点。如果首航点高度低于“安全起飞高度”，则先平飞后下降。
     */
    @XmlElement(name="flyToWaylineMode",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("flyToWaylineMode")
    private String flyToWaylineMode;

    /**
     * 航线结束动作
     * goHome：飞行器完成航线任务后，退出航线模式并返航。noAction：飞行器完成航线任务后，退出航线模式。
     * autoLand：飞行器完成航线任务后，退出航线模式并原地降落。
     * gotoFirstWaypoint：飞行器完成航线任务后，立即飞向航线起始点，到达后退出航线模式。* 注：以上动作执行过程，若飞行器退出了航线模式且进入失控状态，则会优先执行失控动作。
     */
    @XmlElement(name="finishAction",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("finishAction")
    private String finishAction = "goHome";

    /**
     * 失控是否继续执行航线
     * goContinue：继续执行航线
     * executeLostAction：退出航线，执行失控动作
     */
    @XmlElement(name="exitOnRCLost",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("exitOnRCLost")
    private String exitOnRCLost = "executeLostAction";

    /**
     * 失控动作类型
     * goBack：返航。飞行器从失控位置飞向起飞点
     * landing：降落。飞行器从失控位置原地降落
     * hover：悬停。飞行器从失控位置悬停
     *
     * 无，当exitOnRCLost为executeLostAction时为必需元素
     */
    @XmlElement(name="executeRCLostAction",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("executeRCLostAction")
    private String executeRCLostAction = "goBack";

    /**
     * 安全起飞高度 m
     * [1.5, 1500] （高度模式：相对起飞点高度）
     * * 注：飞行器起飞后，先爬升至该高度，再根据“飞向首航点模式”的设置飞至首航点。该元素仅在飞行器未起飞时生效。
     */
    @XmlElement(name="takeOffSecurityHeight",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("takeOffSecurityHeight")
    private Double takeOffSecurityHeight;

    /**
     * 起飞参考点
     * [-90,90],[-180,180],无限制
     * 纬度,经度,高度
     * 注：“参考起飞点”仅做航线规划参考，飞行器执行航线时以飞行器真实的起飞点为准，高度使用椭球高。
     * 无，非必需元素
     */
    @XmlElement(name="takeOffRefPoint",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("takeOffRefPoint")
    private String takeOffRefPoint;

    /**
     *  参考起飞点海拔高度
     *  注：”参考起飞点“海拔高度，与“参考起飞点”中的椭球高度对应。
     *  无，非必需元素
     */
    @XmlElement(name="takeOffRefPointAGLHeight",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("takeOffRefPointAGLHeight")
    private Double takeOffRefPointAGLHeight;

    /**
     * 全局航线过渡速度 m/s
     * [1,15]
     * * 注：飞行器飞往每条航线首航点的速度。航线任务中断时，飞行器从当前位置恢复至断点的速度。
     */
    @XmlElement(name="globalTransitionalSpeed",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("globalTransitionalSpeed")
    private Double globalTransitionalSpeed;

    /**
     * 全局返航高度，即无人机在执行返航命令时的飞行高度。
     * 这个参数可以根据实际情况进行调整，以避免障碍物或其他飞行器。
     */
    @XmlElement(name="globalRTHHeight",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("globalRTHHeight")
    private Integer globalRTHHeight;

    /**
     * 飞行器机型信息
     */
    @XmlElement(name="droneInfo",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("droneInfo")
    private DroneInfo droneInfo;

    /**
     * 负载机型信息
     */
    @XmlElement(name="payloadInfo",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("payloadInfo")
    private PayloadInfo payloadInfo;

    @XmlTransient
    public String getFlyToWaylineMode() {
        return flyToWaylineMode;
    }

    public void setFlyToWaylineMode(String flyToWaylineMode) {
        this.flyToWaylineMode = flyToWaylineMode;
    }
    @XmlTransient
    public String getFinishAction() {
        return finishAction;
    }

    public void setFinishAction(String finishAction) {
        this.finishAction = finishAction;
    }
    @XmlTransient
    public String getExitOnRCLost() {
        return exitOnRCLost;
    }

    public void setExitOnRCLost(String exitOnRCLost) {
        this.exitOnRCLost = exitOnRCLost;
    }
    @XmlTransient
    public String getExecuteRCLostAction() {
        return executeRCLostAction;
    }

    public void setExecuteRCLostAction(String executeRCLostAction) {
        this.executeRCLostAction = executeRCLostAction;
    }

    @XmlTransient
    public DroneInfo getDroneInfo() {
        return droneInfo;
    }

    public void setDroneInfo(DroneInfo droneInfo) {
        this.droneInfo = droneInfo;
    }
    @XmlTransient
    public PayloadInfo getPayloadInfo() {
        return payloadInfo;
    }

    public void setPayloadInfo(PayloadInfo payloadInfo) {
        this.payloadInfo = payloadInfo;
    }
    @XmlTransient
    public Double getTakeOffSecurityHeight() {
        return takeOffSecurityHeight;
    }

    public void setTakeOffSecurityHeight(Double takeOffSecurityHeight) {
        this.takeOffSecurityHeight = takeOffSecurityHeight;
    }
    @XmlTransient
    public Double getGlobalTransitionalSpeed() {
        return globalTransitionalSpeed;
    }

    public void setGlobalTransitionalSpeed(Double globalTransitionalSpeed) {
        this.globalTransitionalSpeed = globalTransitionalSpeed;
    }
    @XmlTransient
    public String getTakeOffRefPoint() {
        return takeOffRefPoint;
    }

    public void setTakeOffRefPoint(String takeOffRefPoint) {
        this.takeOffRefPoint = takeOffRefPoint;
    }
    @XmlTransient
    public Double getTakeOffRefPointAGLHeight() {
        return takeOffRefPointAGLHeight;
    }

    public void setTakeOffRefPointAGLHeight(Double takeOffRefPointAGLHeight) {
        this.takeOffRefPointAGLHeight = takeOffRefPointAGLHeight;
    }
    @XmlTransient
    public Integer getGlobalRTHHeight() {
        return globalRTHHeight;
    }

    public void setGlobalRTHHeight(Integer globalRTHHeight) {
        this.globalRTHHeight = globalRTHHeight;
    }


}
