package facades;

import dtos.MemberDTO;
import entities.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class MemberFacade {

    public MemberFacade() {
    }

    private static MemberFacade instance;
    private static EntityManagerFactory emf;

    


}
