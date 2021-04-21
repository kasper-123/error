package be.vdab.cultuurhuis.restcontrollers;

import be.vdab.cultuurhuis.domain.Genre;
import be.vdab.cultuurhuis.domain.Voorstelling;
import be.vdab.cultuurhuis.services.VoorstellingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voorstellingen")
@CrossOrigin(exposedHeaders = "Location")
public class VoorstellingController {
    private final VoorstellingService voorstellingService;

    public VoorstellingController(VoorstellingService voorstellingService) {
        this.voorstellingService = voorstellingService;
    }

    @GetMapping("{genrenaam}")
    List<Voorstelling> getByGenre(@PathVariable String genrenaam){
     //   return voorstellingService.
    //    return voorstellingService.findByGenreId(genreid);
        return voorstellingService.findByGenreNaam(genrenaam);
    }
}
