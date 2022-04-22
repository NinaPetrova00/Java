package com.citb408.hotel;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Hotel {

    private int numberOfRooms;
    private List<Integer> rooms;

    public Hotel(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
        this.rooms = new ArrayList<>();
    }

    public void rentRoom(int roomNumber) throws InsufficientNumberOfRoomsException, RoomIsRentedException{
        if (rooms.size() >= roomNumber) {
            throw new InsufficientNumberOfRoomsException(this.numberOfRooms);
        } else{
            if(this.rooms.contains(roomNumber)){
                throw new RoomIsRentedException(roomNumber);
            }
        }
        this.rooms.add(roomNumber);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "numberOfRooms=" + numberOfRooms +
                ", rooms=" + rooms +
                '}';
    }
}
