package com.repository;

import com.entity.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room,String> {

    @Query(value = "select * from room order by ROOM_NUMBER",nativeQuery=true)
    List<Room> findRoomList();

}
