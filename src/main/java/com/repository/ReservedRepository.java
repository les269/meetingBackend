package com.repository;

import com.domain.ReservedRequest;
import com.entity.Reserved;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ReservedRepository extends CrudRepository<Reserved,String> {

    @Query(value = "select * from reserved " +
            "where ROOM_HANDLE = :roomHandle AND RESERVED_DATE = :reservedDate AND " +
            "( (START_TIME < :startTime AND END_TIME > :startTime) or (START_TIME < :endTime AND END_TIME > :endTime) or (:startTime >= START_TIME AND END_TIME <= :endTime) )", nativeQuery = true)
    List<Reserved> findSame(@Param("roomHandle") String roomHandle,@Param("reservedDate") String reservedDate,
                            @Param("startTime") String startTime,@Param("endTime") String endTime);


    @Query(value = "INSERT INTO reserved (HANDLE, ROOM_HANDLE, PEOPLE, PURPOSE, RESERVED_DATE, START_TIME, END_TIME)" +
            " VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void insert(String handle,String roomHandle,String people,String purpose,String reservedDate,String startTime,String endTime);

    @Query(value = "select * from reserved where ROOM_HANDLE = :roomHandle", nativeQuery = true)
    List<Reserved> findReservedList(@Param("roomHandle") String roomHandle);
}
