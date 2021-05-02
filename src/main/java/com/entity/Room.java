package com.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="room")
public class Room {
    @Id
    @Column(name = "HANDLE")
    private String handle;
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;
    @Column(name = "PEOPLE_QTY")
    private BigDecimal peopleQty;

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public BigDecimal getPeopleQty() {
        return peopleQty;
    }

    public void setPeopleQty(BigDecimal peopleQty) {
        this.peopleQty = peopleQty;
    }
}
