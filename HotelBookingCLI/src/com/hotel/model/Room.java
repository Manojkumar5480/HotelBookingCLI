package com.hotel.model;

public class Room {
    private final int roomNumber;
    private final String type;
    private final double pricePerNight;
    private boolean booked;
    private String guestName;
    private int nights;

    public Room(int roomNumber, String type, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.booked = false;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getType() { return type; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isBooked() { return booked; }
    public String getGuestName() { return guestName; }
    public int getNights() { return nights; }

    public void book(String guestName, int nights) {
        this.guestName = guestName;
        this.nights = nights;
        this.booked = true;
    }

    public void cancelBooking() {
        this.guestName = null;
        this.nights = 0;
        this.booked = false;
    }

    public double getTotalPrice() {
        return pricePerNight * nights;
    }
}
