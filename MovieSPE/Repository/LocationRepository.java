package com.example.MovieSPE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.MovieSPE.Model.Location;
public interface LocationRepository extends JpaRepository<Location, Integer>{

}
