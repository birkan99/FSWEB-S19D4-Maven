package com.workintech.s19d1.util;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class HollywoodValidation {
    public static void checkMovieIsValid(Movie movie) {
        if (movie == null) {
            throw new ApiException("Movie cannot be null", HttpStatus.BAD_REQUEST);
        }

        if (movie.getRating() != null && (movie.getRating() < 1 || movie.getRating() > 10)) {
            throw new ApiException("Movie credentials are not valid (Rating must be between 1 and 10)", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkActorIsValid(Actor actor) {
        if (actor == null) {
            throw new ApiException("Actor cannot be null", HttpStatus.BAD_REQUEST);
        }
        if (actor.getFirstName() == null || actor.getFirstName().isEmpty() ||
                actor.getLastName() == null || actor.getLastName().isEmpty() ||
                actor.getGender() == null || actor.getBirthDate() == null ||
                actor.getBirthDate().isAfter(LocalDate.now())) {
        }
    }
}