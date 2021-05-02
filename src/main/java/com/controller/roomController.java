package com.controller;

import com.domain.ReservedRequest;
import com.entity.Reserved;
import com.entity.Room;
import com.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class roomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/room/list")
    public List<Room> findRoomList(){
        return roomService.findRoomList();
    }

    @PostMapping("/room/reserved/add")
    public void addReserved(@RequestBody ReservedRequest reserved){
        roomService.addReserved(reserved);
    }

    @GetMapping("/reserved/list")
    public List<Reserved> findReservedList(@RequestParam("roomNumber") String roomNumber){
        return roomService.findReservedList(roomNumber);
    }

    @DeleteMapping("/reserved/delete")
    public void deleteReserved(@RequestParam("handle")String handle){
        roomService.deleteReserved(handle);
    }

}
