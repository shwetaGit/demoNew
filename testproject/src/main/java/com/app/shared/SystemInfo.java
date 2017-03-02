package com.app.shared;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class SystemInfo {

    private static final long serialVersionUID = 1488438392064L;

    @Transient
    @JsonProperty("activeStatus")
    private int activeStatus = 1;

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }
}
