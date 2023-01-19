package facades;

import dtos.DinnereventDTO;
import entities.Dinnerevent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class DinnereventFacade {

    public DinnereventFacade() {
    }

    private static DinnereventFacade instance;
    private static EntityManagerFactory emf;

    public static DinnereventFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new DinnereventFacade();
        }
        return instance;
    }

    public List<DinnereventDTO> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Dinnerevent> query = em.createQuery("SELECT p FROM Dinnerevent p", Dinnerevent.class);
        List<Dinnerevent> rms = query.getResultList();
        return DinnereventDTO.getDtos(rms);

    }

    public DinnereventDTO createEvent(DinnereventDTO pn) {
        Dinnerevent dinnerevent = new Dinnerevent(pn.getDish(), pn.getLacation(), pn.getPricePerPerson(), pn.getTime());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(dinnerevent);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new DinnereventDTO(dinnerevent);
    }

}
