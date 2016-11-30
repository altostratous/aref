package view;

import model.things.Word;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by HP PC on 11/30/2016.
 */
public class Test {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("memory.odb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Word("hello"));
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
