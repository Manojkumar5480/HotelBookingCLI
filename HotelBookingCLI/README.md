# Hotel Booking CLI (Java)

A beginner-friendly console application using Java and OOP.

## Features
- View all rooms
- View available rooms
- Book a room for a guest and number of nights
- Calculate total price
- View booking details
- Cancel a booking
- Validate numeric menu input

## Folder structure
```text
HotelBookingCLI/
├── src/
│   └── com/
│       └── hotel/
│           ├── Main.java
│           ├── cli/
│           │   └── HotelCLI.java
│           ├── model/
│           │   └── Room.java
│           └── service/
│               └── HotelService.java
└── README.md
```

## Run from a terminal
Open a terminal in the `HotelBookingCLI` folder and run:

```bash
javac -d out src/com/hotel/Main.java src/com/hotel/model/Room.java src/com/hotel/service/HotelService.java src/com/hotel/cli/HotelCLI.java
java -cp out com.hotel.Main
```

Bookings are stored in memory, so they reset when the program exits. This is a CLI learning project, not a production booking system.
