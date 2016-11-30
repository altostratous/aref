package model.things;

import model.Thing;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by HP PC on 11/30/2016.
 */
@Entity
public class Word extends Thing{
    @Id
    private String text;

    public Word(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
