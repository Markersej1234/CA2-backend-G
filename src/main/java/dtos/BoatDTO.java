package dtos;

import entities.Boat;
import java.util.ArrayList;
import java.util.List;

public class BoatDTO {

    private long id;
    private String navn;


    public BoatDTO(Boat rm){
        this.id = rm.getId();
        this.navn = rm.getNavn();
    }

    public BoatDTO(long id, String navn) {
        this.id = id;
        this.navn = navn;
    }

    public BoatDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }


    public static List<BoatDTO> getDtos(List<Boat> rms) {
        List<BoatDTO> rmdtos = new ArrayList<>();
        rms.forEach(rm -> rmdtos.add(new BoatDTO(rm)));
        return rmdtos;
    }
}
