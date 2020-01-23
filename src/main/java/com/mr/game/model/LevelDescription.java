package com.mr.game.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:level-description.properties")
@ConfigurationProperties("level")
public class LevelDescription {

    private String instruction1x0;

    private String mission1x0;

    //getters and setters


    public String getInstruction1x0() {
        return instruction1x0;
    }

    public void setInstruction1x0(String instruction1x0) {
        this.instruction1x0 = instruction1x0;
    }

    public String getMission1x0() {
        return mission1x0;
    }

    public void setMission1x0(String mission1x0) {
        this.mission1x0 = mission1x0;
    }
}