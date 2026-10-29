package com.hotel.service;

import com.hotel.model.Room;
import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private final List<Room> rooms = new ArrayList<>();

    public HotelService() {
        rooms.add(new Room(101, "Single", 1200));
        rooms.add(new Room(102, "Single", 1200));
        rooms.add(new Room(201, "Double", 2000));
        rooms.add(new Room(202, "Double", 2000));
        rooms.add(new Room(301, "Deluxe", 3500));
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public boolean bookRoom(int roomNumber, String guestName, int nights) {
        Room room = findRoom(roomNumber);
        if (room == null || room.isBooked() || guestName == null
                || guestName.trim().isEmpty() || nights <= 0) {
            return false;
        }
        room.book(guestName.trim(), nights);
        return true;
    }

    public boolean cancelBooking(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room == null || !room.isBooked()) {
            return false;
        }
        room.cancelBooking();
        return true;
    }

    public Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
