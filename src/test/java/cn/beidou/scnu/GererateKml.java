package cn.beidou.scnu;


import cn.beidou.scnu.dji.*;
import cn.beidou.scnu.util.XmlUtil;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Wpml文件生成测试类
 *
 * @author hqzqaq
 * @ClassName GererateWpml
 * @createTime 2023年03月21日 15:36:00
 */
public class GererateKml {

    public static void main(String[] args) throws JAXBException, ParserConfigurationException, SAXException {
        String path = "./data";
        File saveFolder = new File(path);
        if (!saveFolder.exists()) {
            saveFolder.mkdirs();
        }
        XmlUtil.objectToXML(buildMission(), Paths.get(path, "template.kml").toString());
    }

    public static Kml buildMission() {
        Kml kml = new Kml();
        Document document = new Document();
        MissionConfig missionConfig = new MissionConfig();
        missionConfig.setFlyToWaylineMode("safely");
        missionConfig.setFinishAction("goHome");
        missionConfig.setExitOnRCLost("executeLostAction");
        missionConfig.setExecuteRCLostAction("goBack");
        missionConfig.setTakeOffSecurityHeight(50D);

        missionConfig.setTakeOffRefPoint("23.148073,113.022773,23.300000");
        missionConfig.setTakeOffRefPointAGLHeight(0D);

        missionConfig.setGlobalTransitionalSpeed(10D);
        missionConfig.setGlobalRTHHeight(70);
        document.setMissionConfig(missionConfig);

        // missionConfig.setGlobalTransitionalSpeed(10D);
        // missionConfig.setGlobalRTHHeight(60);
        DroneInfo droneInfo = new DroneInfo(67, 1);
        PayloadInfo payloadInfo = new PayloadInfo(53, 0, 0);
        missionConfig.setDroneInfo(droneInfo);
        missionConfig.setPayloadInfo(payloadInfo);

        Folder folder = new Folder();
        folder.setTemplateId(0);
        folder.setTemplateType("waypoint");


        WaylineCoordinateSysParam waylineCoordinateSysParam = new WaylineCoordinateSysParam();
        waylineCoordinateSysParam.setCoordinateMode("WGS84");
        waylineCoordinateSysParam.setHeightMode("relativeToGround");
        folder.setWaylineCoordinateSysParam(waylineCoordinateSysParam);

        folder.setAutoFlightSpeed(10D);
        folder.setGlobalHeight(70D);
        folder.setCaliFlightEnable(0);
        folder.setGimbalPitchMode("usePointSetting");

        folder.setExecuteHeightMode("relativeToStartPoint");


        folder.setGlobalWaypointTurnMode("toPointAndStopWithDiscontinuityCurvature");
        folder.setGlobalUseStraightLine(1);

        Placemark placemark1 = new Placemark();
        Point point = new Point();
        point.setCoordinates("113.02284812154,23.1479920050768");
        placemark1.setPoint(point);
        placemark1.setIndex(0);
        placemark1.setExecuteHeight(70D);
        placemark1.setWaypointSpeed(10D);
        WaypointHeadingParam waypointHeadingParam = new WaypointHeadingParam();
        waypointHeadingParam.setWaypointHeadingMode("followWayline");
        waypointHeadingParam.setWaypointHeadingAngle(0);
        waypointHeadingParam.setWaypointPoiPoint("0.000000,0.000000,0.000000");
        waypointHeadingParam.setWaypointHeadingAngleEnable(0);
        waypointHeadingParam.setWaypointHeadingPathMode("followBadArc");
        waypointHeadingParam.setWaypointHeadingPoiIndex(0);
        placemark1.setWaypointHeadingParam(waypointHeadingParam);

        WaypointTurnParam waypointTurnParam = new WaypointTurnParam();
        waypointTurnParam.setWaypointTurnMode("toPointAndStopWithDiscontinuityCurvature");
        waypointTurnParam.setWaypointTurnDampingDist(0D);
        placemark1.setWaypointTurnParam(waypointTurnParam);
        placemark1.setUseStraightLine(1);

        ActionGroup actionGroup = new ActionGroup();
        actionGroup.setActionGroupId(1);
        actionGroup.setActionGroupStartIndex(0);
        actionGroup.setActionGroupEndIndex(0);
        actionGroup.setActionGroupMode("sequence");
        ActionTrigger actionTrigger = new ActionTrigger();
        actionTrigger.setActionTriggerType("reachPoint");
        actionGroup.setActionTrigger(actionTrigger);

        Action action = new Action();
        action.setActionId(0);
        action.setActionActuatorFunc("takePhoto");
        ActionActuatorFuncParam actionActuatorFuncParam = new ActionActuatorFuncParam();
        actionActuatorFuncParam.setFileSuffix("Waypoint1");
        actionActuatorFuncParam.setPayloadPositionIndex(0);
        actionActuatorFuncParam.setUseGlobalPayloadLensIndex(1);
        actionActuatorFuncParam.setPayloadLensIndex("ir,wide,zoom");

        List<ActionGroup> actionGroups = new ArrayList<>();
        actionGroups.add(actionGroup);
        placemark1.setActionGroup(actionGroups);

        List<Placemark> placemarks = new ArrayList<>();
        placemarks.add(placemark1);
        folder.setPlacemark(placemarks);
        document.setFolder(folder);
        kml.setDocument(document);
        return kml;
    }
}
