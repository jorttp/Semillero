package co.edu.uco.reactiveexample.service.impl;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.CountryPublisher;
import co.edu.uco.reactiveexample.repository.CountryRepository;
import co.edu.uco.reactiveexample.service.CountryService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;
    private final CountryPublisher publisher;
    public CountryServiceImpl(CountryRepository repository, CountryPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }
    @Override
    public Mono<CountryEntity> create(final CountryEntity country) {
        return repository.save(country).then(repository.findByName(country.getName())).doOnNext(publisher::sendCreatedEvent);
    }

    @Override
    public Mono<CountryEntity> update(final int id, final CountryEntity country) {
        return repository.findById(id).flatMap(existingCountry -> {
            existingCountry.setDialingCountryCode(country.getDialingCountryCode());
            existingCountry.setIsoCountryCode(country.getIsoCountryCode());
            existingCountry.setName(country.getName());
            return repository.save(existingCountry);
        });
    }

    @Override
    public Mono<CountryEntity> delete(int id) {
        return repository.findById(id).flatMap(existingCountry -> repository.delete(existingCountry).then(Mono.just(existingCountry)));
    }

    @Override
    public Mono<CountryEntity> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Mono<CountryEntity> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Flux<CountryEntity> findAll() {
        return repository.findAll();
    }

}
