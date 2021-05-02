package com.service.room;

import com.domain.ReservedRequest;
import com.entity.Reserved;
import com.entity.Room;
import com.exception.BaseException;
import com.exception.CustomException;
import com.repository.ReservedRepository;
import com.repository.RoomRepository;
import com.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservedRepository reservedRepository;

    public List<Room> findRoomList() {
        return roomRepository.findRoomList();
    }

    @Override
    public void addReserved(ReservedRequest reserved) {
        List<Reserved> reservedList =
        reservedRepository.findSame(
                reserved.getRoomHandle(),
                reserved.getReservedDate(),
                reserved.getStartTime(),
                reserved.getEndTime());
        // 有被預約的資料
        if(!Utils.isEmpty(reservedList)){
            //組成時間
            List<String> timeList = reservedList
                    .stream()
                    .map(res -> res.getStartTime() + "~" +res.getEndTime())
                    .collect(Collectors.toList());
            String[] timeArr = new String[timeList.size()];
            timeArr = timeList.toArray(timeArr);
            //報錯
            Utils.getCustomException("reserved.error",new Object[]{String.join("", timeArr)});
        }
        //設定handle
        StringBuffer handle = new StringBuffer();
        handle.append("ReservedHandle:")
                .append(reserved.getRoomHandle())
                .append(",")
                .append(reserved.getReservedDate())
                .append(",")
                .append(reserved.getStartTime())
                .append(",")
                .append(reserved.getEndTime());
        reserved.setHandle(handle.toString());
        Reserved data = new Reserved();
        data.setHandle(handle.toString());
        data.setRoomHandle(reserved.getRoomHandle());
        data.setPeople(reserved.getPeople());
        data.setPurpose(reserved.getPurpose());
        data.setReservedDate(reserved.getReservedDate());
        data.setStartTime(reserved.getStartTime());
        data.setEndTime(reserved.getEndTime());
        reservedRepository.save(data);
//        reservedRepository.d(
//                reserved.getHandle(),
//                reserved.getRoomHandle(),
//                reserved.getPeople(),
//                reserved.getPurpose(),
//                reserved.getReservedDate(),
//                reserved.getStartTime(),
//                reserved.getEndTime());
    }

    @Override
    public List<Reserved> findReservedList(String roomNumber) {

        return reservedRepository.findReservedList("HANDLE:" + roomNumber);
    }

    @Override
    public void deleteReserved(String handle) {
        reservedRepository.deleteById(handle);
    }
}
