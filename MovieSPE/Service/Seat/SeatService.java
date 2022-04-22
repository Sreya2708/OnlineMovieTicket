package com.example.MovieSPE.Service.Seat;

import com.example.MovieSPE.Model.Seats;

import java.util.List;

public interface SeatService {
    public List<Seats> listAllSeats();
    public Seats addSeat(Seats seat);
    public int getSeatCost(String seatType);
}
