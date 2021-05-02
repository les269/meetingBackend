package com.domain;

import java.util.Date;

public class ReservedRequest {
    private String handle;
    private String roomHandle;
    private String people;
    private String purpose;
    private String reservedDate;
    private String startTime;
    private String endTime;

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getRoomHandle() {
        return roomHandle;
    }

    public void setRoomHandle(String roomHandle) {
        this.roomHandle = roomHandle;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(String reservedDate) {
        this.reservedDate = reservedDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
