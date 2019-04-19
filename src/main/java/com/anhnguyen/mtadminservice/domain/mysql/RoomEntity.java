package com.anhnguyen.mtadminservice.domain.mysql;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "room", schema = "movie_cinema", catalog = "")
public class RoomEntity {
    private int idRoom;
    private String nameRoom;
    private Integer numRow;
    private Integer numCol;
    private Integer createBy;
    private Timestamp timeCreate;
    private Integer updateBy;
    private Timestamp timeUpdate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room")
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "name_room")
    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    @Basic
    @Column(name = "num_row")
    public Integer getNumRow() {
        return numRow;
    }

    public void setNumRow(Integer numRow) {
        this.numRow = numRow;
    }

    @Basic
    @Column(name = "num_col")
    public Integer getNumCol() {
        return numCol;
    }

    public void setNumCol(Integer numCol) {
        this.numCol = numCol;
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
        RoomEntity that = (RoomEntity) o;
        return idRoom == that.idRoom &&
                Objects.equals(nameRoom, that.nameRoom) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(timeCreate, that.timeCreate) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(timeUpdate, that.timeUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom, nameRoom, createBy, timeCreate, updateBy, timeUpdate);
    }


}
