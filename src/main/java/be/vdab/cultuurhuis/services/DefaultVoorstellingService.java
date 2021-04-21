package be.vdab.cultuurhuis.services;

import be.vdab.cultuurhuis.domain.Genre;
import be.vdab.cultuurhuis.domain.Voorstelling;
import be.vdab.cultuurhuis.repositories.VoorstellingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class DefaultVoorstellingService implements VoorstellingService{
private final VoorstellingRepository voorstellingRepository;

    public DefaultVoorstellingService(VoorstellingRepository voorstellingRepository) {
        this.voorstellingRepository = voorstellingRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Voorstelling> findByGenreId(long genreId) {
        return voorstellingRepository.findAllByGenreId(genreId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Voorstelling> findByGenreNaam(String naam) {
        return voorstellingRepository.findByGenreNaam(naam);

    }
}
