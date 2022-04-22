package com.example.MovieSPE.Service.Show;

import com.example.MovieSPE.Model.Booking;
import com.example.MovieSPE.Model.Shows;
import com.example.MovieSPE.Repository.ShowRepository;
import com.example.MovieSPE.Repository.TheatreRepository;
import com.example.MovieSPE.Service.Theatre.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreRepository theatreRepository;

  

    public List<Shows> listAllShows() {
        return showRepository.findAll();
    }

    public boolean addShow(Shows show) {
        if(theatreRepository.existsById(show.getTheatreId())){
            if(showRepository.existsById(show.getShowid())) {
                return false;
            }
            else{
                showRepository.save(show);
                
                return true;
            }
        }
        else{
            return false;
        }
    }

    public List<Shows> showsById(Integer TheatreId,Integer movieId) {
        return showRepository.showByMovieandLocationId(TheatreId,movieId);
    }

   // public void updateShow(Booking booking) {
   //     showRepository.updateShow(1, booking.getTime(), booking.getTicketCount(), booking.getShowid());
   // }

  //  public void rollbackShow(String showid) {
  //      showRepository.rollbackShow(showid);
  //  }
}
