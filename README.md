English [中文版](README-zh_CN.md)

# DJI-Mission-Parser A jar package for DJI route wpml file and javabean object interconversion.

`DJI-Mission-Parser` is a tool that provides mutual conversion between DJI route files and javabean objects, based on the standard of route format documents provided by [Cloud API (dji.com)](https://developer.dji.com/doc/cloud-api-tutorial/cn/api-reference/dji-wpml/overview.html), which can be used for the development of DJI [Cloud API (dji.com)](https://developer.dji.com/doc/cloud-api-tutorial/cn/) to draw DJI route functions.

**Key Features**

Currently, `DJI-Mission-Parser` offers the following main methods:

* **Mapping of route parameters to javabean objects**
* **javabean to route file**: 
* **Route file to javabean**

## Install

`DJI-Mission-Parser` is compiled and run using JDK 17.

### Installation with Maven

#### Clone

```sh
git clone https://github.com/hqzqaq/DJI-Mission-Parser.git
```

#### Build

Before installing `DJI-Mission-Parser`, make sure you have **Maven** installed: [Maven – Download Apache Maven](https://maven.apache.org/download.cgi)
If you already have Maven installed, just compile the project:

![build](E:\code\java\DJI-Mission-Parser\data\build.png)

A jar package dji-mission-parser-1.0.jar will appear in the target directory

#### Installation into local maven repository

After compilation, you can refer to the jar package directly in the project or installed to the local maven repository, with the maven way to refer to the following maven way to refer to:

    mvn install:install-file -DgroupId=cn.beidou.scnu -DartifactId=dji-mission-parser -Dversion=1.0 -Dfile=dji-mission-parser-1.0.jar -Dpackaging=jar

One thing to keep in mind：`-Dfile=[jar path]`

#### Maven dependency introduction

```xml
<dependencies>
    <dependency>
        <groupId>cn.beidou.scnu</groupId>
        <artifactId>dji-mission-parser</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
```

## Usage example

### Javabean to file

The following example shows how to convert a javabean object to a route file using the `DJI-Mission-Parser` tool

```java
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
```

### kml or wpml to javabean

```java
public class ReadKml {
    public static void main(String[] args) throws JAXBException {
        String path = "./data/wpmz/waylines.wpml";
        Kml kml = readKmlContent(path);
        System.out.println(XmlUtil.objectToXML(kml));
    }

    public static Kml readKmlContent(String kmlPath) throws JAXBException {
        File kmlFile = new File(kmlPath);
        if (!kmlFile.exists()) {
            return null;
        }
        return XmlUtil.xmlToBean(kmlFile, Kml.class);
    }
}
```

## Related links

* DJI Cloud API Route Documentation： https://developer.dji.com/doc/cloud-api-tutorial/cn/feature-set/dock-feature-set/dock-wayline-management.html