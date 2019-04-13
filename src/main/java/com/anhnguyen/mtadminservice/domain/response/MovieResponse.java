package com.anhnguyen.mtadminservice.domain.response;

import com.anhnguyen.mtadminservice.domain.mysql.CategoryEntity;
import com.anhnguyen.mtadminservice.domain.mysql.MovieEntity;

import java.util.List;

public class MovieResponse {
    private MovieEntity movie;
    private List<CategoryEntity> categorys;

    public MovieResponse() {
    }

    public MovieResponse(MovieEntity movie, List<CategoryEntity> categorys) {
        this.movie = movie;
        this.categorys = categorys;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public List<CategoryEntity> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<CategoryEntity> categorys) {
        this.categorys = categorys;
    }
}
