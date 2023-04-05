package com.mr.game.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:level-description.properties")
@ConfigurationProperties("level")
public class LevelDescription {
    private String info1x0;
    private String mission1x0;
    private String info1x1;
    private String mission1x1;
    private String info1x2;
    private String mission1x2;
    private String info1x3;
    private String mission1x3;
    private String info1x4;
    private String mission1x4;
    private String info2x0;
    private String mission2x0;
    private String info2x1;
    private String mission2x1;
    private String info3x0;
    private String mission3x0;
    private String info4x0;
    private String mission4x0;
    private String heroTable;
    private String heroNameRealNameTable;
    private String heroNameRealNameBecomeStoriesHowPlaceTable;

    public String getInfo(String level) {
        String info = "";
        switch (level) {
            case "1.0":
                info = getInfo1x0();
                break;
            case "1.1":
                info = getInfo1x1();
                break;
            case "1.2":
                info = getInfo1x2();
                break;
            case "1.3":
                info = getInfo1x3();
                break;
            case "1.4":
                info = getInfo1x4();
                break;
            case "2.0":
                info = getInfo2x0();
                break;
            case "2.1":
                info = getInfo2x1();
                break;
            case "3.0":
                info = getInfo3x0();
                break;
            case "4.0":
                info = getInfo4x0();
                break;
            default:
                break;
        }
        return info;
    }

    public String getMission(String level) {
        String mission = "";
        switch (level) {
            case "1.0":
                mission = getMission1x0();
                break;
            case "1.1":
                mission = getMission1x1();
                break;
            case "1.2":
                mission = getMission1x2();
                break;
            case "1.3":
                mission = getMission1x3();
                break;
            case "1.4":
                mission = getMission1x4();
                break;
            case "2.0":
                mission = getMission2x0();
                break;
            case "2.1":
                mission = getMission2x1();
                break;
            case "3.0":
                mission = getMission3x0();
                break;
            case "4.0":
                mission = getMission4x0();
                break;
            default:
                break;
        }
        return mission;
    }

    public String getInfo1x0() {
        return info1x0;
    }

    public void setInfo1x0(String info1x0) {
        this.info1x0 = info1x0;
    }

    public String getMission1x0() {
        return mission1x0;
    }

    public void setMission1x0(String mission1x0) {
        this.mission1x0 = mission1x0;
    }

    public String getInfo1x1() {
        return info1x1;
    }

    public void setInfo1x1(String info1x1) {
        this.info1x1 = info1x1;
    }

    public String getMission1x1() {
        return mission1x1;
    }

    public void setMission1x1(String mission1x1) {
        this.mission1x1 = mission1x1;
    }

    public String getInfo1x2() {
        return info1x2;
    }

    public void setInfo1x2(String info1x2) {
        this.info1x2 = info1x2;
    }

    public String getMission1x2() {
        return mission1x2;
    }

    public void setMission1x2(String mission1x2) {
        this.mission1x2 = mission1x2;
    }

    public String getInfo1x3() {
        return info1x3;
    }

    public void setInfo1x3(String info1x3) {
        this.info1x3 = info1x3;
    }

    public String getMission1x3() {
        return mission1x3;
    }

    public void setMission1x3(String mission1x3) {
        this.mission1x3 = mission1x3;
    }

    public String getInfo1x4() {
        return info1x4;
    }

    public void setInfo1x4(String info1x4) {
        this.info1x4 = info1x4;
    }

    public String getMission1x4() {
        return mission1x4;
    }

    public void setMission1x4(String mission1x4) {
        this.mission1x4 = mission1x4;
    }

    public String getInfo2x0() {
        return info2x0;
    }

    public void setInfo2x0(String info2x0) {
        this.info2x0 = info2x0;
    }

    public String getMission2x0() {
        return mission2x0;
    }

    public void setMission2x0(String mission2x0) {
        this.mission2x0 = mission2x0;
    }

    public String getInfo2x1() {
        return info2x1;
    }

    public void setInfo2x1(String info2x1) {
        this.info2x1 = info2x1;
    }

    public String getMission2x1() {
        return mission2x1;
    }

    public void setMission2x1(String mission2x1) {
        this.mission2x1 = mission2x1;
    }

    public String getInfo3x0() {
        return info3x0;
    }

    public void setInfo3x0(String info3x0) {
        this.info3x0 = info3x0;
    }

    public String getMission3x0() {
        return mission3x0;
    }

    public void setMission3x0(String mission3x0) {
        this.mission3x0 = mission3x0;
    }

    public String getInfo4x0() {
        return info4x0;
    }

    public void setInfo4x0(String info4x0) {
        this.info4x0 = info4x0;
    }

    public String getMission4x0() {
        return mission4x0;
    }

    public void setMission4x0(String mission4x0) {
        this.mission4x0 = mission4x0;
    }

    public String getHeroTable() {
        return heroTable;
    }

    public void setHeroTable(String heroTable) {
        this.heroTable = heroTable;
    }

    public String getHeroNameRealNameTable() {
        return heroNameRealNameTable;
    }

    public void setHeroNameRealNameTable(String heroNameRealNameTable) {
        this.heroNameRealNameTable = heroNameRealNameTable;
    }

    public String getHeroNameRealNameBecomeStoriesHowPlaceTable() {
        return heroNameRealNameBecomeStoriesHowPlaceTable;
    }

    public void setHeroNameRealNameBecomeStoriesHowPlaceTable(String heroNameRealNameBecomeStoriesHowPlaceTable) {
        this.heroNameRealNameBecomeStoriesHowPlaceTable = heroNameRealNameBecomeStoriesHowPlaceTable;
    }
}