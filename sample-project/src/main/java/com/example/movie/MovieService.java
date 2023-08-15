package com.example.movie;

import com.example.annotation.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieService {


    public MovieDto fetchMovieByIdWithoutAop(Integer movieId){
        try {
            log.info("Transaction started.....");
            checkMovieId(movieId);
            MovieDto movieDto = new MovieDto(movieId, "Race " + movieId);
            log.info("Transaction committed....");
            return movieDto;
        } catch (Exception e) {
            log.info("Transaction rollback....");
            throw new RuntimeException(e);
        }
    }

    @Transaction
    public MovieDto fetchMovieWithAop(Integer movieId , String movieName){
        checkMovieId(movieId);
        return new MovieDto(movieId, movieName);
    }

    private static void checkMovieId(Integer movieId) {
        if (movieId < 1){
            throw new IllegalArgumentException("movieId should not be less then 1");
        }
    }

}
