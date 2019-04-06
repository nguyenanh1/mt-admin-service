package com.anhnguyen.mtadminservice.domain.mysql;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "seat", schema = "movie_cinema", catalog = "")
public class SeatEntity {
    private int idSeat;
    private int rowSeate;
    private int colSeate;
    private Integer type;
    private Integer idRoom;

    @Id
    @Column(name = "id_seat")
    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    @Basic
    @Column(name = "row_seate")
    public int getRowSeate() {
        return rowSeate;
    }

    public void setRowSeate(int rowSeate) {
        this.rowSeate = rowSeate;
    }

    @Basic
    @Column(name = "col_seate")
    public int getColSeate() {
        return colSeate;
    }

    public void setColSeate(int colSeate) {
        this.colSeate = colSeate;
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
    @Column(name = "id_room")
    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatEntity that = (SeatEntity) o;
        return idSeat == that.idSeat &&
                rowSeate == that.rowSeate &&
                colSeate == that.colSeate &&
                Objects.equals(type, that.type) &&
                Objects.equals(idRoom, that.idRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSeat, rowSeate, colSeate, type, idRoom);
    }
}
