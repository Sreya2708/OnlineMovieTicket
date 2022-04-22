package com.example.MovieSPE.Controller;

import com.example.MovieSPE.Model.Booking;
import com.example.MovieSPE.Service.booking.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking/add")
    public Booking add(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    @GetMapping("/booking")
    public List<Booking> listAll(){
        return bookingService.listAllBooking();
    }

    @GetMapping("booking/getByUser/{email}")
    public List<Booking> listByUsers(@PathVariable String email){
        return bookingService.listByUser(email);
    }

    @GetMapping("/booking/endBooking/{bookingid}")
    public boolean endBooking(@PathVariable Integer bookingid) {
        return bookingService.endBooking(bookingid);
    }

    @GetMapping("/booking/allBooking")
    public List<Booking> allBookings(){
        return bookingService.listAllBooking();
    }
}
