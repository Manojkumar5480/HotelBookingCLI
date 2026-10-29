package com.hotel;

import com.hotel.cli.HotelCLI;
import com.hotel.service.HotelService;

public class Main {
    public static void main(String[] args) {
        HotelService service = new HotelService();
        HotelCLI cli = new HotelCLI(service);
        cli.start();
    }
}
