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
 * 航点动作
 *
 * @author hqzqaq
 * @ClassName Action
 * @createTime 2023年03月20日 20:36:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Action implements Serializable {
    private static final long serialVersionUID = 1946928643661388234L;

    /**
     * 动作id
     * * 注：在一个动作组内该ID唯一。建议从0开始单调连续递增。
     * [0, 65535]
     */
    @XmlElement(name = "actionId", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("actionId")
    private Integer actionId;

    /**
     * 动作类型
     * takePhoto：单拍
     * startRecord：开始录像
     * stopRecord：结束录像
     * focus：对焦
     * zoom：变焦
     * customDirName：创建新文件夹
     * gimbalRotate：旋转云台
     * rotateYaw：飞行器偏航
     * hover：悬停等待
     */
    @XmlElement(name = "actionActuatorFunc", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("actionActuatorFunc")
    private String actionActuatorFunc;

    /**
     * 动作参数
     */
    @XmlElement(name = "actionActuatorFuncParam", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("actionActuatorFuncParam")
    private ActionActuatorFuncParam actionActuatorFuncParam;

    @XmlTransient
    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    @XmlTransient
    public String getActionActuatorFunc() {
        return actionActuatorFunc;
    }

    public void setActionActuatorFunc(String actionActuatorFunc) {
        this.actionActuatorFunc = actionActuatorFunc;
    }

    @XmlTransient
    public ActionActuatorFuncParam getActionActuatorFuncParam() {
        return actionActuatorFuncParam;
    }

    public void setActionActuatorFuncParam(ActionActuatorFuncParam actionActuatorFuncParam) {
        this.actionActuatorFuncParam = actionActuatorFuncParam;
    }
}
