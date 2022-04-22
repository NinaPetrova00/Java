package com.citb408.hotel;

public class RoomIsRentedException extends Exception{

    private final int roomNumber;

    public RoomIsRentedException( int roomNumber) {
      this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "RoomIsRentedException{" +
                "roomNumber=" + roomNumber +
                "} " + super.toString();
    }
}
