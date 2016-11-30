package model;

import javax.persistence.Entity;

/**
 * Created by HP PC on 11/30/2016.
 */
@Entity
public class IsA {
    private Thing subject;
    private Thing object;

    public IsA(Thing subject, Thing object) {
        this.subject = subject;
        this.object = object;
    }

    public Thing getSubject() {
        return subject;
    }

    public void setSubject(Thing subject) {
        this.subject = subject;
    }

    public Thing getObject() {
        return object;
    }

    public void setObject(Thing object) {
        this.object = object;
    }
}
