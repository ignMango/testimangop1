package ar.com.imango.examen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "loans")
public class Loans implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "total")
    private Double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users user;

    public Loans() {
    }

    public Loans(Double total, Users user) {
        this.total = total;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Users getUserId() {
        return user;
    }

    public void setUserId(Users userId) {
        this.user = userId;
    }
}
