package com.example.bootwithtesting.controller;

import com.example.bootwithtesting.dto.MovieDTO;
import com.example.bootwithtesting.dto.MoviewResponse;
import com.example.bootwithtesting.model.Movie;
import com.example.bootwithtesting.model.Review;
import com.example.bootwithtesting.service.MovieServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {
    @InjectMocks private MovieController movieController;
    @Mock
    private MovieServiceImpl movieService;
    private  MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @BeforeEach
    public void setUp(){
        this.mockMvc= MockMvcBuilders.standaloneSetup(movieController)
                .setControllerAdvice().build();
        this.objectMapper=new ObjectMapper();
    }
    @Test
    public void testControllerForGetAllMovies() throws Exception{
        when(movieService.getAllMovie(1,2)).thenReturn(getMovieResponse());
        this.mockMvc.perform(
                get("/api/movie?pageNo=1&pageSize=2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)

        ).andExpect(status().isOk());
    }

private MoviewResponse getMovieResponse(){
   return  MoviewResponse.builder()
            .content(getMovieDto())
            .pageNo(1)
            .pageSize(10)
            .totalElements(1)
            .totalPages(1)
            .last(true)
            .build();

}

private List<MovieDTO> getMovieDto(){
    return
            List.of(MovieDTO.builder()
                .name("qqwq")
                .type("qwqw")
                .build(),
               MovieDTO.builder()
                       .name("qwqw")
                       .type("qwqw")
                       .build()
               );
}
private Movie getMovie(){
        return Movie.builder()
                .id(101)
                .name("fdfdf")
                .reviews(getReviews())
                .build();
}
private List<Review> getReviews(){
        return List.of(Review.builder()
                .movie(getMovie())
                .content("asasas")
                .title("asas")
                .stars(4)
                .build(),
                Review.builder()
                        .movie(getMovie())
                        .content("asasas")
                        .title("asas")
                        .stars(4)
                        .build());
}
}
