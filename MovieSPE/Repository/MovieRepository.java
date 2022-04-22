package com.example.MovieSPE.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MovieSPE.Model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}