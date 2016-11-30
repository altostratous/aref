package model;

import javax.persistence.Entity;

/**
 * Created by HP PC on 11/30/2016.
 */
@Entity
public class IsA {
    private Word subject;
    private Word object;
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public IsA(Word subject, Word object, double weight) {
        this.subject = subject;
        this.object = object;
        this.weight = weight;
    }

    public Word getSubject() {
        return subject;
    }

    public void setSubject(Word subject) {
        this.subject = subject;
    }

    public Word getObject() {
        return object;
    }

    public void setObject(Word object) {
        this.object = object;
    }
}
