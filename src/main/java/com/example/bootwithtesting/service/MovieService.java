package com.example.bootwithtesting.service;

import com.example.bootwithtesting.dto.MovieDTO;
import com.example.bootwithtesting.dto.MoviewResponse;
import com.example.bootwithtesting.model.Movie;

public interface MovieService {
    MovieDTO createMoview(Movie movie);

    MoviewResponse getAllMoview(int pageNo, int pageSize);

    MovieDTO getMoviewById(int id);

    MovieDTO updateMoview(MovieDTO movieDto, int id);

    void deleteMoviewId(int id);
}
