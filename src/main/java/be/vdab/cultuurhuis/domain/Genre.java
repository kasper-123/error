package be.vdab.cultuurhuis.domain;

import javax.persistence.*;

@Entity
@Table(name="genres")
public class Genre {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String naam;

    protected Genre(){}
    public Genre(String naam) {
        this.naam = naam;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam.trim();
    }

    @Override
    public String toString(){
        return id + "     " +naam;
    }
}
