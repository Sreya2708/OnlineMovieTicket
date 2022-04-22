package com.example.MovieSPE.Service.booking;

import com.example.MovieSPE.Model.Booking;
import com.example.MovieSPE.Repository.BookingRepository;
import com.example.MovieSPE.Service.Seat.SeatService;
import com.example.MovieSPE.Service.Show.ShowService;
import com.example.MovieSPE.Service.Theatre.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SeatService seatService;

 

    @Autowired
    private ShowService showService;

    public Booking addBooking(Booking booking) {
        int no_of_tickets = booking.getTicketCount();
        int seatCost = seatService.getSeatCost(booking.getSeat_type());

        int cost  = no_of_tickets * seatCost;
        booking.setCost(String.valueOf(cost));
        bookingRepository.save(booking);
        return booking;
    }

    public List<Booking> listAllBooking() {
        return bookingRepository.findAll();
    }

    public List<Booking> listByUser(String email) {
        return bookingRepository.listBookingByUser(email);
    }

    public boolean endBooking(Integer bookingid) {
        bookingRepository.endBooking(bookingid);

        int ticketCount = bookingRepository.findById(bookingid).get().getTicketCount();
        Booking currBooking = bookingRepository.findById((bookingid)).get();
        currBooking.setTicketCount(ticketCount);

        int seatCost = seatService.getSeatCost(currBooking.getSeat_type());
        int cost = seatCost * ticketCount;
        currBooking.setCost(String.valueOf(cost));

        bookingRepository.save(currBooking);
     //   showService.rollbackShow(currBooking.getShowid());
        return true;
    }

    public String[] getDate() {
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
        String time = sd.format(date);
        String[] dateArray = time.split("-");
        return (dateArray);
    }

    public String[] getTime() {
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
        String time = sd.format(date);
        String[] timeArray = time.split(":");
        return (timeArray);
    }

    public String[] splitDate(String date) {
        return date.split("-");
    }

    public String[] splitTime(String time) {
        return time.split("-");
    }
}
