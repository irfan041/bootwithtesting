package com.example.bootwithtesting.service;

import com.example.bootwithtesting.dto.MovieDTO;
import com.example.bootwithtesting.dto.MoviewResponse;
import com.example.bootwithtesting.model.Movie;
import com.example.bootwithtesting.model.Review;
import com.example.bootwithtesting.repository.MoviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MoviewRepository moviewRepository;

    @Override
    public MovieDTO createMoview(Movie movie) {

        Movie newPokemon = moviewRepository.save(movie);

        MovieDTO movieResponse = new MovieDTO();
        movieResponse.setId(newPokemon.getId());
        movieResponse.setName(newPokemon.getName());
        movieResponse.setType(newPokemon.getType());
        return movieResponse;
    }

    @Override
    public MoviewResponse getAllMoview(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public MovieDTO getMoviewById(int id) {
        return null;
    }

    @Override
    public MovieDTO updateMoview(MovieDTO movieDto, int id) {
        return null;
    }

    @Override
    public void deleteMoviewId(int id) {

    }
}
