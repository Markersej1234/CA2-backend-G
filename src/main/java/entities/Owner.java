package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Owner {
    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String name;
    private String phone;
    private String address;


    public Owner() {
    }

    @ManyToMany()
    private List<Boat> boatList = new ArrayList<>();

    public Owner(long id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void addBoat(Boat boat) {

        if (boat != null) {
            this.boatList.add(boat);
            boat.getOwners().add(this);

        }


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Boat> getBoatList() {
        return boatList;
    }

    public void setBoatList(List<Boat> boatList) {
        this.boatList = boatList;
    }
}