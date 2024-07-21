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
 * 动作触发
 *
 * @author hqzqaq
 * @ClassName ActionTrigger
 * @createTime 2023年03月20日 20:32:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ActionTrigger implements Serializable {
    private static final long serialVersionUID = -6853101473163097237L;
    /**
     * 动作触发器类型
     * reachPoint：到达航点时执行
     * betweenAdjacentPoints：航段触发，均匀转云台
     * multipleTiming：等时触发
     * multipleDistance：等距触发
     * * 注：“betweenAdjacentPoints”需配合动作"gimbalEvenlyRotate"使用
     */
    @XmlElement(name="actionTriggerType",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("actionTriggerType")
    private String actionTriggerType;

    /**
     * 动作触发器参数
     * > 0
     * * 注：当“动作触发器类型”为“multipleTiming”时，该参数为动作触发间隔时间，单位为秒。
     * * 注：当“动作触发器类型”为“multipleDistance”时，该参数为动作触发间隔距离，单位为米。
     */
    @XmlElement(name="actionTriggerParam",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("actionTriggerParam")
    private Double actionTriggerParam;


    @XmlTransient
    public String getActionTriggerType() {
        return actionTriggerType;
    }

    public void setActionTriggerType(String actionTriggerType) {
        this.actionTriggerType = actionTriggerType;
    }

    @XmlTransient
    public Double getActionTriggerParam() {
        return actionTriggerParam;
    }

    public void setActionTriggerParam(Double actionTriggerParam) {
        this.actionTriggerParam = actionTriggerParam;
    }
}
