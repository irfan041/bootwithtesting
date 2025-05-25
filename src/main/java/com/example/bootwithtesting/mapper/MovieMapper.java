package com.example.bootwithtesting.mapper;

import com.example.bootwithtesting.dto.MovieDTO;
import com.example.bootwithtesting.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface MovieMapper {

    //@Mapping(source = "argument objet property", target = " return type object property")
    MovieDTO MovieMapperToMovieDTO(Movie movie);

    List<MovieDTO> mapMovieToMovieDTO(List<Movie> movies);
}
