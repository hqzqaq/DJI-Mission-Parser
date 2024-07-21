package cn.beidou.scnu.dji;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 文档
 *
 * @author hqzqaq
 * @ClassName Document
 * @createTime 2023年03月20日 14:56:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Document implements java.io.Serializable{

    private static final long serialVersionUID = -8907353814515972633L;

    @XmlElement(name="missionConfig",namespace = "http://www.dji.com/wpmz/1.0.3")
    @JsonProperty("missionConfig")
    private MissionConfig missionConfig;

    @XmlElement(name="Folder")
    @JsonProperty("Folder")
    private Folder folder;

    @XmlTransient
    public MissionConfig getMissionConfig() {
        return missionConfig;
    }

    public void setMissionConfig(MissionConfig missionConfig) {
        this.missionConfig = missionConfig;
    }
    @XmlTransient
    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }


}
