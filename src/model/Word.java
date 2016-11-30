package model;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;


/**
 * Created by HP PC on 11/30/2016.
 */
@Entity
public class Word{
    @PrimaryKey
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
