package be.vdab.cultuurhuis.services;

import be.vdab.cultuurhuis.domain.Genre;
import be.vdab.cultuurhuis.domain.Voorstelling;

import java.util.List;

public interface VoorstellingService {

    List<Voorstelling> findByGenreId(long id);
   List<Voorstelling> findByGenreNaam(String naam);
}
