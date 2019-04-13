package com.anhnguyen.mtadminservice.domain.mysql;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "movie", schema = "movie_cinema", catalog = "")
public class MovieEntity {
    private int id;
    private Integer status;
    private String name;
    private Integer partTime;
    private Integer time;
    private String director;
    private String contain;
    private String trailer;
    private String thumb;
    private String imageUrl;
    private String actor;
    private Integer old;
    private Long view;
    private Integer createBy;
    private Timestamp timeCreate;
    private Integer updateBy;
    private Timestamp timeUpdate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "part_time")
    public Integer getPartTime() {
        return partTime;
    }

    public void setPartTime(Integer partTime) {
        this.partTime = partTime;
    }

    @Basic
    @Column(name = "time")
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Basic
    @Column(name = "director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Basic
    @Column(name = "contain")
    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    @Basic
    @Column(name = "trailer")
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Basic
    @Column(name = "thumb")
    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "actor")
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Basic
    @Column(name = "old")
    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    @Basic
    @Column(name = "view")
    public Long getView() {
        return view;
    }

    public void setView(Long view) {
        this.view = view;
    }

    @Basic
    @Column(name = "create_by")
    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    @Basic
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    @Column(name = "time_create")
    public Timestamp getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }

    @Basic
    @Column(name = "update_by")
    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    @Column(name = "time_update")
    public Timestamp getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(Timestamp timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return id == that.id &&
                Objects.equals(status, that.status) &&
                Objects.equals(name, that.name) &&
                Objects.equals(partTime, that.partTime) &&
                Objects.equals(time, that.time) &&
                Objects.equals(director, that.director) &&
                Objects.equals(contain, that.contain) &&
                Objects.equals(trailer, that.trailer) &&
                Objects.equals(thumb, that.thumb) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(actor, that.actor) &&
                Objects.equals(old, that.old) &&
                Objects.equals(view, that.view) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(timeCreate, that.timeCreate) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(timeUpdate, that.timeUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, name, partTime, time, director, contain, trailer, thumb, imageUrl, actor, old, view, createBy, timeCreate, updateBy, timeUpdate);
    }
}
