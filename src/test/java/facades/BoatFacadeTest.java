//package facades;
//
//import edu.emory.mathcs.backport.java.util.Arrays;
//import dtos.BoatDTO;
//import entities.Boat;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import utils.EMF_Creator;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.containsInAnyOrder;
//import static org.junit.jupiter.api.Assertions.*;
//
//class BoatFacadeTest {
//
//    private static EntityManagerFactory emf;
//    private static BoatFacade facade;
//    private Boat m1, m2;
//
//    @BeforeAll
//    public static void setUpClass()
//    {
//        emf = EMF_Creator.createEntityManagerFactoryForTest();
//        facade = BoatFacade.getInstance(emf);
//
//    }
//
//    @BeforeEach
//    void setUp()
//    {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.createNamedQuery("Boat.deleteAllRows").executeUpdate();
//            m1 = new Boat(1,"Anna");
//            m2 = new Boat(1, "valborg");
//
//            em.persist(m1);
//            em.persist(m2);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//
//
//    @Test
//    void getAllBoats()  {
//        List<BoatDTO> boatDTOList = facade.getAllBoats();
//        int expected = 2;
//        int actual = boatDTOList.size();
//        assertEquals(expected, actual);
//        assertThat(boatDTOList, containsInAnyOrder(new BoatDTO(m1), new BoatDTO(m2)));
//    }
//
//    @Test
//    void createBoat() {
//    }
//
//    @Test
//    void deleteBoat() {
//    }
//
//    @Test
//    void updateBoat() {
//    }
//}