package com.example.bootwithtesting.service;

import com.example.bootwithtesting.dto.MovieDTO;
import com.example.bootwithtesting.dto.MoviewResponse;
import com.example.bootwithtesting.model.Movie;
import com.example.bootwithtesting.repository.MoviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
        Pageable pageable = PageRequest.of(pageNo, pageSize);
     Page<Movie> movies=moviewRepository.findAll(pageable);
        List<Movie> listOfMovie = movies.getContent();
        List<MovieDTO> content = listOfMovie.stream().map(p -> mapToDto(p)).collect(Collectors.toList());

        MoviewResponse movieResponse = new MoviewResponse();
        movieResponse.setContent(content);
        movieResponse.setPageNo(movies.getNumber());
        movieResponse.setPageSize(movies.getSize());
        movieResponse.setTotalElements(movies.getTotalElements());
        movieResponse.setTotalPages(movies.getTotalPages());
        movieResponse.setLast(movies.isLast());

        return movieResponse;
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

    private MovieDTO mapToDto(Movie movie) {
        MovieDTO movieDto = new MovieDTO();

        movieDto.setId(movie.getId());
        movieDto.setName(movie.getName());
        movieDto.setType(movie.getType());

        return movieDto;
    }
}
