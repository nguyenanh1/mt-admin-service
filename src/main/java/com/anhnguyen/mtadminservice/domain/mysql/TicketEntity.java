package com.anhnguyen.mtadminservice.domain.mysql;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ticket", schema = "movie_cinema", catalog = "")
public class TicketEntity {
    private int idTicket;
    private Integer status;
    private Integer price;
    private Integer idMovietime;
    private Integer idZoomDetail;
    private Integer createBy;
    private Timestamp timeCreate;
    private Integer updateBy;
    private Timestamp timeUpdate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
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
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "id_movietime")
    public Integer getIdMovietime() {
        return idMovietime;
    }

    public void setIdMovietime(Integer idMovietime) {
        this.idMovietime = idMovietime;
    }

    @Basic
    @Column(name = "id_zoom_detail")
    public Integer getIdZoomDetail() {
        return idZoomDetail;
    }

    public void setIdZoomDetail(Integer idZoomDetail) {
        this.idZoomDetail = idZoomDetail;
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
        TicketEntity that = (TicketEntity) o;
        return idTicket == that.idTicket &&
                Objects.equals(status, that.status) &&
                Objects.equals(price, that.price) &&
                Objects.equals(idMovietime, that.idMovietime) &&
                Objects.equals(idZoomDetail, that.idZoomDetail) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(timeCreate, that.timeCreate) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(timeUpdate, that.timeUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTicket, status, price, idMovietime, idZoomDetail, createBy, timeCreate, updateBy, timeUpdate);
    }
}
