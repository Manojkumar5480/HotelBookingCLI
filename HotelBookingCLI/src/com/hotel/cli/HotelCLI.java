package com.hotel.cli;

import com.hotel.model.Room;
import com.hotel.service.HotelService;
import java.util.Scanner;

public class HotelCLI {
    private final HotelService service;
    private final Scanner scanner = new Scanner(System.in);

    public HotelCLI(HotelService service) {
        this.service = service;
    }

    public void start() {
        int choice;
        do {
            System.out.println("\\n===== HOTEL BOOKING SYSTEM =====");
            System.out.println("1. View all rooms");
            System.out.println("2. View available rooms");
            System.out.println("3. Book a room");
            System.out.println("4. Cancel booking");
            System.out.println("5. View booking details");
            System.out.println("0. Exit");
            choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: showRooms(false); break;
                case 2: showRooms(true); break;
                case 3: bookRoom(); break;
                case 4: cancelBooking(); break;
                case 5: showBooking(); break;
                case 0: System.out.println("Thank you for using the system!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void showRooms(boolean availableOnly) {
        System.out.println("\\n--- Room List ---");
        for (Room room : service.getAllRooms()) {
            if (!availableOnly || !room.isBooked()) {
                System.out.printf("Room %d | %-7s | Rs. %.2f/night | %s%n",
                        room.getRoomNumber(), room.getType(), room.getPricePerNight(),
                        room.isBooked() ? "BOOKED" : "AVAILABLE");
            }
        }
    }

    private void bookRoom() {
        showRooms(true);
        int roomNumber = readInt("Enter room number to book: ");
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine().trim();
        int nights = readInt("Enter number of nights: ");

        if (service.bookRoom(roomNumber, guestName, nights)) {
            Room room = service.findRoom(roomNumber);
            System.out.println("Booking successful!");
            System.out.printf("Guest: %s | Room: %d | Total: Rs. %.2f%n",
                    room.getGuestName(), room.getRoomNumber(), room.getTotalPrice());
        } else {
            System.out.println("Booking failed. Check room number, guest name, nights, and availability.");
        }
    }

    private void cancelBooking() {
        int roomNumber = readInt("Enter room number to cancel: ");
        System.out.println(service.cancelBooking(roomNumber)
                ? "Booking cancelled successfully."
                : "Cancellation failed. Room not found or not booked.");
    }

    private void showBooking() {
        int roomNumber = readInt("Enter room number: ");
        Room room = service.findRoom(roomNumber);
        if (room == null) {
            System.out.println("Room not found.");
        } else if (!room.isBooked()) {
            System.out.println("Room " + roomNumber + " is not booked.");
        } else {
            System.out.println("\\n--- Booking Details ---");
            System.out.println("Room number: " + room.getRoomNumber());
            System.out.println("Room type: " + room.getType());
            System.out.println("Guest name: " + room.getGuestName());
            System.out.println("Nights: " + room.getNights());
            System.out.printf("Price per night: Rs. %.2f%n", room.getPricePerNight());
            System.out.printf("Total amount: Rs. %.2f%n", room.getTotalPrice());
        }
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
