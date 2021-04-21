package be.vdab.cultuurhuis.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "voorstellingen")
public class Voorstelling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titel;
    private String uitvoerders;
    private Date datum;

    @ManyToOne
    @JoinColumn(name = "genreid")
    private Genre genre;

 private BigDecimal prijs;
int vrijeplaatsen;

protected Voorstelling(){}
    public Voorstelling(String titel, String uitvoerders, Date datum, Genre genre, BigDecimal prijs, int vrijeplaatsen) {
        this.titel = titel;
        this.uitvoerders = uitvoerders;
        this.datum = datum;
        this.genre = genre;
        this.prijs = prijs;
        this.vrijeplaatsen = vrijeplaatsen;
    }

    public long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getUitvoerders() {
        return uitvoerders;
    }

    public Date getDatum() {
        return datum;
    }

    public Genre getGenre() {
        return genre;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public int getVrijeplaatsen() {
        return vrijeplaatsen;
    }
}
