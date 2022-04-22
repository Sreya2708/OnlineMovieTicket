package com.example.MovieSPE.Service.Theatre;

import com.example.MovieSPE.Model.Theatre;

import java.util.List;

public interface TheatreService {
    public List<Theatre> listAllTheatre();
    public boolean addTheatre(Theatre theatre);
  
    public List<Theatre> findTheatreByMovieandLocation(int locationid,int movieid);
}
