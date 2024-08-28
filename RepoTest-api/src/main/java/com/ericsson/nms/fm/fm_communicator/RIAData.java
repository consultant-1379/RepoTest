package com.ericsson.nms.fm.fm_communicator;
import java.io.Serializable;
import java.util.Arrays;



/**
 * @author xnavrat
 *
 */
public class RIAData implements Serializable {
    
    private static final long serialVersionUID = 8902184529980921057L;
    private boolean deltaSynchSupported;
    private boolean sourceSynchSupported;
    private boolean synchable;
    private boolean synchOnCommFailureClear;
    private boolean acknowledgeSupported;
    private boolean closeSupported;
    private  ClearAllBehaviour    clearAllBehaviour;
    private long     communicationTimeOut;
    private boolean      subordinateObjectSynchSupported;
    private String[]      filterInfo;

      public boolean isDeltaSynchSupported() {
        return deltaSynchSupported;
    }
    public void setDeltaSynchSupported(boolean deltaSynchSupported) {
        this.deltaSynchSupported = deltaSynchSupported;
    }
    public boolean isSourceSynchSupported() {
        return sourceSynchSupported;
    }
    public void setSourceSynchSupported(boolean sourceSynchSupported) {
        this.sourceSynchSupported = sourceSynchSupported;
    }
    public boolean isSynchable() {
        return synchable;
    }
    public void setSynchable(boolean synchable) {
        this.synchable = synchable;
    }
    public boolean isSynchOnCommFailureClear() {
        return synchOnCommFailureClear;
    }
    public void setSynchOnCommFailureClear(boolean synchOnCommFailureClear) {
        this.synchOnCommFailureClear = synchOnCommFailureClear;
    }
    public boolean isAcknowledgeSupported() {
        return acknowledgeSupported;
    }
    public void setAcknowledgeSupported(boolean acknowledgeSupported) {
        this.acknowledgeSupported = acknowledgeSupported;
    }
    public boolean isCloseSupported() {
        return closeSupported;
    }
    public void setCloseSupported(boolean closeSupported) {
        this.closeSupported = closeSupported;
    }
    public ClearAllBehaviour getClearAllBehaviour() {
        return clearAllBehaviour;
    }
    public void setClearAllBehaviour(ClearAllBehaviour clearAllBehaviour) {
        this.clearAllBehaviour = clearAllBehaviour;
    }
    public long getCommunicationTimeOut() {
        return communicationTimeOut;
    }
    public void setCommunicationTimeOut(long communicationTimeOut) {
        this.communicationTimeOut = communicationTimeOut;
    }
    public boolean isSubordinateObjectSynchSupported() {
        return subordinateObjectSynchSupported;
    }
    public void setSubordinateObjectSynchSupported(
            boolean subordinateObjectSynchSupported) {
        this.subordinateObjectSynchSupported = subordinateObjectSynchSupported;
    }
    public String[] getFilterInfo() {
        return filterInfo;
    }
    public void setFilterInfo(String[] filterInfo) {
        this.filterInfo = filterInfo;
    }


public String toString() {
        return "RIAData [deltaSynchSupported=" + deltaSynchSupported
                + ", sourceSynchSupported=" + sourceSynchSupported
                + ", synchable=" + synchable + ", synchOnCommFailureClear="
                + synchOnCommFailureClear + ", acknowledgeSupported="
                + acknowledgeSupported + ", closeSupported=" + closeSupported
                + ", communicationTimeOut=" + communicationTimeOut
                + ", subordinateObjectSynchSupported="
                + subordinateObjectSynchSupported + ", filterInfo="
                + (filterInfo != null ? Arrays.asList(filterInfo) : null) + "]";
    }


public enum ClearAllBehaviour {
     CLOSE_ALL,
     SYNCHRONIZE,
     CLOSE_ALL_AND_SYNCHRONIZE

 }

}

