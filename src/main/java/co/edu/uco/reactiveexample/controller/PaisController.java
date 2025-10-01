package co.edu.uco.reactiveexample.controller;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.repository.CountryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/countries")
public class PaisController {

    private CountryRepository repository;

    public PaisController( final CountryRepository repository) {
        super();
        this.repository = repository;
    }



    @GetMapping()
    public Flux<CountryEntity> getAllCountries() {
        return repository.findAll();
    }
}
