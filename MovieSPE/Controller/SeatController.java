package com.example.MovieSPE.Controller;

import com.example.MovieSPE.Model.Seats;
import com.example.MovieSPE.Service.Seat.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/seat")
    public List<Seats> list() {
        return seatService.listAllSeats();
    }

    @PostMapping("/seat/add")
    public ResponseEntity<Seats> add(@RequestBody Seats seat) {
        return new ResponseEntity<Seats>(seatService.addSeat(seat), HttpStatus.OK);
    }
}
