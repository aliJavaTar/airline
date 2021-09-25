package hibernatutil;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Jpa {
    private static final EntityManagerFactory entityMangerFactory;
    static
    {
        entityMangerFactory= Persistence.createEntityManagerFactory("airline");
    }

    public static EntityManagerFactory getEntityMangerFactory() {
        return entityMangerFactory;
    }
}
