package com.example.bootwithtesting.controller;

import com.example.bootwithtesting.dto.MovieDTO;
import com.example.bootwithtesting.dto.MoviewResponse;
import com.example.bootwithtesting.model.Movie;
import com.example.bootwithtesting.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
public class MoviewController {
    private MovieService movieService;

    @PostMapping("movie/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createPokemon(@RequestBody Movie movie) {
      //  return new ResponseEntity<>(movieService.createMoview(movie), HttpStatus.CREATED);
        movieService.createMoview(movie);
        return ResponseEntity.status(HttpStatus.CREATED).build();

        //return ResponseEntity.ok().body(MovieDTO.builder().success(true).build());
    }
    @GetMapping("movie")
    public ResponseEntity<MoviewResponse> getPokemons(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return new ResponseEntity<>(movieService.getAllMoview(pageNo, pageSize), HttpStatus.OK);
    }
}
