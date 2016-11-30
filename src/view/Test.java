package view;

import controller.Memory;
import model.IsA;
import model.Word;

/**
 * Created by HP PC on 11/30/2016.
 */
public class Test {
    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("memory.odb");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(new Word("hello"));
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();
        Memory memory = new Memory("memory.odb");
        memory.know(new IsA(new Word("ali"), new Word("good"), 0.8));
        memory.know(new IsA(new Word("he"), new Word("ali"), 0.5));
        System.out.println(memory.measure(new IsA( new Word("he"), new Word("good"), 0.1)));
        memory.close();
    }
}
