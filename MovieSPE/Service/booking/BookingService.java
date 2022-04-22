package com.example.MovieSPE.Service.booking;


import com.example.MovieSPE.Model.Booking;

import java.util.List;

public interface BookingService {
    public Booking addBooking(Booking booking);
    public List<Booking> listAllBooking();
    public List<Booking> listByUser(String email);
    public boolean endBooking(Integer bookingid);
    public String[] getDate();
    public String[] getTime();
    public String[] splitDate(String date);
    public String[] splitTime(String time);
}
