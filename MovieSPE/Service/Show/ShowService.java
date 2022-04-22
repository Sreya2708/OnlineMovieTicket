package com.example.MovieSPE.Service.Show;

import com.example.MovieSPE.Model.Booking;
import com.example.MovieSPE.Model.Shows;

import java.util.List;

public interface ShowService {
    public List<Shows> listAllShows();
    public boolean addShow(Shows show);
    public List<Shows> showsById(Integer TheatreId,Integer MoviedId);
  //  public void updateShow(Booking booking);
   // public void rollbackShow(String showid);
}
