package com.example.bootwithtesting.service;

import com.example.bootwithtesting.dto.MovieDTO;
import com.example.bootwithtesting.dto.MoviewResponse;
import com.example.bootwithtesting.model.Movie;

import java.util.List;

public interface MovieService {
    MovieDTO createMovie(Movie movie);

    MoviewResponse getAllMovie(int pageNo, int pageSize);
    List<Movie> getAllMovieWithDetails();

    MovieDTO getMovieById(int id);

    MovieDTO updateMovie(MovieDTO movieDto, int id);

    void deleteMovieId(int id);
}
