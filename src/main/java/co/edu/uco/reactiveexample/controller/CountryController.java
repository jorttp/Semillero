package co.edu.uco.reactiveexample.controller;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.repository.CountryRepository;
import co.edu.uco.reactiveexample.service.CountryService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private CountryService service;

    public CountryController( final CountryService service) {
        super();
        this.service = service;
    }



    @GetMapping()
    public Flux<CountryEntity> getAllCountries() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<CountryEntity> findById(final @PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/{id}")
    public Mono<CountryEntity> create(final @RequestBody CountryEntity country) {
        return service.create(country);
    }

    @PutMapping("/{id}")
    public Mono<CountryEntity> update(final @PathVariable int id, final @RequestBody CountryEntity country) {
        return service.update(id,country);
    }

    @DeleteMapping("/{id}")
    public Mono<CountryEntity> delete(final @PathVariable int id) {
        return service.delete(id);
    }
}
