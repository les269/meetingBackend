package com.service.room;


import com.domain.ReservedRequest;
import com.entity.Reserved;
import com.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findRoomList();
    void addReserved(ReservedRequest reserved);
    List<Reserved> findReservedList(String roomNumber);
    void deleteReserved(String handle);
}
