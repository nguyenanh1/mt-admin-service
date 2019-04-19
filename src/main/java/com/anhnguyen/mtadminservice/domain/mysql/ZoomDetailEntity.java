package com.anhnguyen.mtadminservice.domain.mysql;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "zoom_detail", schema = "movie_cinema", catalog = "")
public class ZoomDetailEntity {
    private int id;
    private Integer row;
    private Integer col;
    private Integer type;
    private Integer postion;
    private Integer room;

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
    @Column(name = "row")
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    @Basic
    @Column(name = "col")
    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "postion")
    public Integer getPostion() {
        return postion;
    }

    public void setPostion(Integer postion) {
        this.postion = postion;
    }

    @Basic
    @Column(name = "room")
    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZoomDetailEntity that = (ZoomDetailEntity) o;
        return id == that.id &&
                Objects.equals(row, that.row) &&
                Objects.equals(col, that.col) &&
                Objects.equals(type, that.type) &&
                Objects.equals(postion, that.postion) &&
                Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, col, type, postion, room);
    }
}
