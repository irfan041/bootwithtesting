package com.example.bootwithtesting.service;

import com.example.bootwithtesting.dto.MovieDTO;
import com.example.bootwithtesting.dto.MoviewResponse;
import com.example.bootwithtesting.mapper.MovieMapper;
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
    private final MovieMapper movieResponse;

    @Override
    public MovieDTO createMovie(Movie movie) {

        Movie movie1 = moviewRepository.save(movie);

/*
        MovieDTO movieResponse = new MovieDTO();
        movieResponse.setId(movie1.getId());
        movieResponse.setName(movie1.getName());
        movieResponse.setType(movie1.getType());

 */
        return movieResponse.MovieMapperToMovieDTO(movie1);
    }

    @Override
    public MoviewResponse getAllMovie(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
     Page<Movie> movies=moviewRepository.findAll(pageable);
        List<Movie> listOfMovie = movies.getContent();
        List<MovieDTO> content = listOfMovie.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
/*
        MoviewResponse movieResponse = new MoviewResponse();
        movieResponse.setContent(content);
        movieResponse.setPageNo(movies.getNumber());
        movieResponse.setPageSize(movies.getSize());
        movieResponse.setTotalElements(movies.getTotalElements());
        movieResponse.setTotalPages(movies.getTotalPages());
        movieResponse.setLast(movies.isLast());

        return movieResponse;
       */
       return MoviewResponse.builder()
                .content(content)
                .last(movies.isLast())
                .totalElements(movies.getTotalElements())
                .totalPages(movies.getTotalPages())
                .pageNo(movies.getNumber())
                .pageSize(movies.getSize())
                .build();
    }
@Override
   public List<Movie> getAllMovieWithDetails(){
        return moviewRepository.findAll();
    }

    @Override
    public MovieDTO getMovieById(int id) {

        Movie movie= moviewRepository.findById(id).get();

        return MovieDTO.builder()
                .name(movie.getName())
                .type(movie.getType())
                .build();
    }

    @Override
    public MovieDTO updateMovie(MovieDTO movieDto, int id) {
        return null;
    }

    @Override
    public void deleteMovieId(int id) {

    }

    private MovieDTO mapToDto(Movie movie) {
//        MovieDTO movieDto = new MovieDTO();
//
//        movieDto.setId(movie.getId());
//        movieDto.setName(movie.getName());
//        movieDto.setType(movie.getType());
//
//        return movieDto;

        return MovieDTO.builder()
                .name(movie.getName())
                .type(movie.getType())
                .build();
    }
}
