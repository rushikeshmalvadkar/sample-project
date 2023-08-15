package com.example.movie;

import com.example.annotation.Log;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/movies")
@Slf4j
@RequiredArgsConstructor
public class MovieRestController {

    private final MovieService movieService;

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable("movie-id") Integer movieId){
        MovieDto movieDto = this.movieService.fetchMovieByIdWithoutAop(movieId);
        return ResponseEntity.ok(movieDto);
    }

    @GetMapping("/{movieId}/{movieName}")
    @Log
    public ResponseEntity<MovieDto> getMovie(@PathVariable("movieId") Integer movieId ,
                                             @PathVariable("movieName") String movieName){
        MovieDto movieDto = this.movieService.fetchMovieWithAop(movieId , movieName);
        return ResponseEntity.ok(movieDto);
    }

}
