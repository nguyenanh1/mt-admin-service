package com.anhnguyen.mtadminservice.domain.mysql;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "moviecategory", schema = "movie_cinema", catalog = "")
public class MoviecategoryEntity {
    private int id;
    private Integer idCategory;
    private Integer idMovie;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_category")
    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    @Basic
    @Column(name = "id_movie")
    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviecategoryEntity that = (MoviecategoryEntity) o;
        return id == that.id &&
                Objects.equals(idCategory, that.idCategory) &&
                Objects.equals(idMovie, that.idMovie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCategory, idMovie);
    }
}
