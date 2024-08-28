package com.ericsson.nms.fm.fm_communicator;

import java.io.Serializable;

public class FmNeProperties implements Serializable{
    
    
    
    private static final long serialVersionUID = 8902184529980921059L;
    private boolean autoSync;
    private boolean nodeSuspended;
    private String sourceType;
    private boolean heartBeatSupervision;
    private int heartBeatTimeout;
    private boolean alarmSupervision;
    public boolean isAutoSync() {
        return autoSync;
    }
    public void setAutoSync(boolean autoSync) {
        this.autoSync = autoSync;
    }
    public boolean isNodeSuspended() {
        return nodeSuspended;
    }
    public void setNodeSuspended(boolean nodeSuspended) {
        this.nodeSuspended = nodeSuspended;
    }
    public String getSourceType() {
        return sourceType;
    }
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }
    public boolean isHeartBeatSupervision() {
        return heartBeatSupervision;
    }
    public void setHeartBeatSupervision(boolean heartBeatSupervision) {
        this.heartBeatSupervision = heartBeatSupervision;
    }
    public int getHeartBeatTimeout() {
        return heartBeatTimeout;
    }
    public void setHeartBeatTimeout(int heartBeatTimeout) {
        this.heartBeatTimeout = heartBeatTimeout;
    }
    public boolean isAlarmSupervision() {
        return alarmSupervision;
    }
    public void setAlarmSupervision(boolean alarmSupervision) {
        this.alarmSupervision = alarmSupervision;
    }
    public String toString() {
        return "FmNeProperties [autoSync=" + autoSync + ", nodeSuspended="
                + nodeSuspended + ", sourceType=" + sourceType
                + ", heartBeatSupervision=" + heartBeatSupervision
                + ", heartBeatTimeout=" + heartBeatTimeout
                + ", alarmSupervision=" + alarmSupervision + "]";
    }
    
    
    

}