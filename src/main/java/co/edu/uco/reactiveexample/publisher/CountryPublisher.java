package co.edu.uco.reactiveexample.publisher;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.event.CountryEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;
@Service
public class CountryPublisher {

    private final Sinks.Many<CountryEvent> sink = Sinks.many().multicast().onBackpressureBuffer();

    public void sendCreatedEvent(final CountryEntity country){
        sink.tryEmitNext(new CountryEvent(country, CountryEvent.EventType.CREATED));
    }
    public void sendUpdatedEvent(final CountryEntity country){
        sink.tryEmitNext(new CountryEvent(country, CountryEvent.EventType.UPDATED));
    }
    public void sendDeletedEvent(final CountryEntity country){
        sink.tryEmitNext(new CountryEvent(country, CountryEvent.EventType.DELETED));
    }
}
