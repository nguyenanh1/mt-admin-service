package com.anhnguyen.mtadminservice.domain.mysql;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "detail_transaction", schema = "movie_cinema", catalog = "")
public class DetailTransactionEntity {
    private int id;
    private Integer idTransaction;
    private Integer idTicket;

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
    @Column(name = "id_transaction")
    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    @Basic
    @Column(name = "id_ticket")
    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailTransactionEntity that = (DetailTransactionEntity) o;
        return id == that.id &&
                Objects.equals(idTransaction, that.idTransaction) &&
                Objects.equals(idTicket, that.idTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTransaction, idTicket);
    }
}
