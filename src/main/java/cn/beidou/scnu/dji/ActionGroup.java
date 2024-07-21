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
 * 航点动作组
 *
 * @author hqzqaq
 * @ClassName ActionGroup
 * @createTime 2023年03月20日 20:15:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ActionGroup implements Serializable {
    private static final long serialVersionUID = -7642380408238724522L;

    /**
     * 动作组id
     * * 注：在一个kmz文件内该ID唯一。建议从0开始单调连续递增。
     * [0, 65535]
     */
    @XmlElement(name = "actionGroupId", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("actionGroupId")
    private Integer actionGroupId;

    /**
     * 动作组开始生效的航点
     * [0, 65535]
     */
    @XmlElement(name = "actionGroupStartIndex", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("actionGroupStartIndex")
    private Integer actionGroupStartIndex;

    /**
     * 动作组结束生效的航点
     * * 注：当“动作组结束生效的航点”与“动作组开始生效的航点”一致，则代表该动作组仅在该航点处生效。
     */
    @XmlElement(name = "actionGroupEndIndex", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("actionGroupEndIndex")
    private Integer actionGroupEndIndex;

    /**
     * 动作执行模式
     * sequence：串行执行。即动作组内的动作依次按顺序执行。
     */
    @XmlElement(name = "actionGroupMode", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("actionGroupMode")
    private String actionGroupMode = "sequence";

    /**
     * 动作触发器
     */
    @XmlElement(name = "actionTrigger", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("actionTrigger")
    private ActionTrigger actionTrigger;

    /**
     * 动作列表
     */
    @XmlElement(name = "action", namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("action")
    private List<Action> action;

    @XmlTransient
    public Integer getActionGroupId() {
        return actionGroupId;
    }

    public void setActionGroupId(Integer actionGroupId) {
        this.actionGroupId = actionGroupId;
    }

    @XmlTransient
    public Integer getActionGroupStartIndex() {
        return actionGroupStartIndex;
    }

    public void setActionGroupStartIndex(Integer actionGroupStartIndex) {
        this.actionGroupStartIndex = actionGroupStartIndex;
    }

    @XmlTransient
    public Integer getActionGroupEndIndex() {
        return actionGroupEndIndex;
    }

    public void setActionGroupEndIndex(Integer actionGroupEndIndex) {
        this.actionGroupEndIndex = actionGroupEndIndex;
    }

    @XmlTransient
    public String getActionGroupMode() {
        return actionGroupMode;
    }

    public void setActionGroupMode(String actionGroupMode) {
        this.actionGroupMode = actionGroupMode;
    }

    @XmlTransient
    public ActionTrigger getActionTrigger() {
        return actionTrigger;
    }

    public void setActionTrigger(ActionTrigger actionTrigger) {
        this.actionTrigger = actionTrigger;
    }

    @XmlTransient
    public List<Action> getAction() {
        return action;
    }

    public void setAction(List<Action> action) {
        this.action = action;
    }

}
