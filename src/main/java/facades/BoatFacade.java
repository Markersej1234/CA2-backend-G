package facades;

import dtos.BoatDTO;
import dtos.DinnereventDTO;
import entities.Boat;
import entities.Dinnerevent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class BoatFacade {

    public BoatFacade() {
    }

    private static BoatFacade instance;
    private static EntityManagerFactory emf;

    public static BoatFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BoatFacade();
        }
        return instance;
    }

    public List<BoatDTO> getAllBoats() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Boat> query = em.createQuery("SELECT p FROM Boat p", Boat.class);
        List<Boat> rms = query.getResultList();
        return BoatDTO.getDtos(rms);

    }

    public BoatDTO createBoat(BoatDTO pn) {
        Boat boat = new Boat(pn.getId(), pn.getNavn());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(boat);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new BoatDTO(boat);
    }

    public void deleteBoat(int pn) {
        EntityManager em = emf.createEntityManager();
        Boat a = (em.find(Boat.class, (int)pn));
        try {
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public BoatDTO updateBoat(BoatDTO pn) {
        EntityManager em = emf.createEntityManager();
        Boat a = (em.find(Boat.class, pn.getId()));
        try {
            a.setNavn(pn.getNavn());
            //måske add get set id
            em.getTransaction().begin();
            a = em.merge(a);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new BoatDTO(a);

    }

}
