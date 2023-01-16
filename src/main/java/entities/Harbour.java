package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@NamedQuery(name = "Auction.deleteAllRows", query = "DELETE from Harbour")
public class Harbour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private int capacity;

    @OneToMany(mappedBy = "harbour")
    private List<Boat> boatList;

    public Harbour() {
    }

    public Harbour(long id, String name, String address, int capacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Harbour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                ", boatList=" + boatList +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Boat> getBoatList() {
        return boatList;
    }

    public void setBoatList(List<Boat> boatList) {
        this.boatList = boatList;
    }

    public Harbour(long id, String name, String address, int capacity, List<Boat> boatList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.boatList = boatList;
    }
}