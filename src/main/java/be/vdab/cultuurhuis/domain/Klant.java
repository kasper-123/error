package be.vdab.cultuurhuis.domain;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.*;


@Entity
@Table(name = "klanten")
public class Klant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;


}
