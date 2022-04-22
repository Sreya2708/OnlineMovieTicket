package com.example.MovieSPE.Service.Seat;

import com.example.MovieSPE.Model.Seats;
import com.example.MovieSPE.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seats> listAllSeats() {
        return seatRepository.findAll();
    }

    public Seats addSeat(Seats seat) {
        Seats newSeat = seatRepository.save(seat);
        return newSeat;
    }

    public int getSeatCost(String seatType) {
        String cost = seatRepository.getSeatCost(seatType);
        return Integer.parseInt(cost);
    }
}
