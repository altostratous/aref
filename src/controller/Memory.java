package controller;

import model.IsA;
import model.Word;

import javax.jdo.identity.LongIdentity;
import javax.persistence.*;
import java.util.List;

/**
 * Created by HP PC on 11/30/2016.
 */
public class Memory {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    public Memory(String database){
        entityManagerFactory = Persistence.createEntityManagerFactory(database);
        entityManager = entityManagerFactory.createEntityManager();
    }
    public void know(IsA isA){
        handleWord(isA.getSubject());
        handleWord(isA.getObject());
        TypedQuery<IsA> isAQuery =  entityManager.createQuery("SELECT isA FROM IsA isA WHERE " +
                "isA.subject = :subject AND " +
                "isA.object = :object", IsA.class);
        isAQuery.setParameter("subject", isA.getSubject());
        isAQuery.setParameter("object", isA.getObject());
        IsA lastIsA = null;
        try {
            lastIsA = isAQuery.getSingleResult();
        }catch (NoResultException ex){}
        entityManager.getTransaction().begin();
        if (lastIsA == null){
            entityManager.persist(isA);
        } else {
            lastIsA.setWeight(Math.max(lastIsA.getWeight(), isA.getWeight()));
        }
        entityManager.getTransaction().commit();
        List<IsA> backIsAs =  entityManager.createQuery("SELECT isA FROM IsA isA WHERE " +
                "isA.subject = :object OR " +
                "isA.object = :subject", IsA.class)
                    .setParameter("subject", isA.getSubject())
                    .setParameter("object", isA.getObject()).getResultList();
        for (IsA isAElement :
                backIsAs) {
            if (isAElement.getObject().getText().equals(lastIsA.getSubject().getText())) {
                know(new IsA(isAElement.getSubject(), lastIsA.getObject(), isAElement.getWeight() * lastIsA.getWeight()));
            } else {
                know(new IsA(lastIsA.getSubject(), isAElement.getObject(), isAElement.getWeight() * lastIsA.getWeight()));
            }
        }
    }
    public void handleWord(Word word){
        try {
            if ((Long) entityManager.createQuery("SELECT COUNT(word) FROM Word word WHERE word.text = :wordText").setParameter("wordText",
                    word.getText()).getSingleResult() == 0) {
                entityManager.getTransaction().begin();
                entityManager.persist(word);
                entityManager.getTransaction().commit();
            }
        }catch (PersistenceException ex){
            entityManager.getTransaction().begin();
            entityManager.persist(word);
            entityManager.getTransaction().commit();
        }
    }
    public void close(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
