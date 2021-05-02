package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "reserved")
public class Reserved {
    @Id
    @Column(name = "HANDLE")
    private String handle;
    @Column(name = "ROOM_HANDLE")
    private String roomHandle;
    @Column(name = "PEOPLE")
    private String people;
    @Column(name = "PURPOSE")
    private String purpose;
    @Column(name = "RESERVED_DATE")
    private String reservedDate;
    @Column(name = "START_TIME")
    private String startTime;
    @Column(name = "END_TIME")
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
