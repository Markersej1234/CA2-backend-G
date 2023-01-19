package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "Dinnerevent.deleteAllRows", query = "DELETE from Dinnerevent ")

public class Dinnerevent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date time;
    private String lacation;
    private String dish;
    private int pricePerPerson;

    @OneToMany(mappedBy = "dinnerevent")
    private List<Assignment> assignmentList;

    public Dinnerevent() {
    }

    public Dinnerevent(long id, Date time, String lacation, String dish, int pricePerPerson) {
        this.id = id;
        this.time = time;
        this.lacation = lacation;
        this.dish = dish;
        this.pricePerPerson = pricePerPerson;
    }

    public Dinnerevent(Date time, String lacation, String dish, int pricePerPerson) {
    }


    //wat?
//    public Auction(long id, String name, String date, String time, String location) {
//        this.id = id;
//        this.name = name;
//        this.date = date;
//        this.time = time;
//        this.location = location;
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLacation() {
        return lacation;
    }

    public void setLacation(String lacation) {
        this.lacation = lacation;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public int getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(int pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

}
