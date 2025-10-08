package co.edu.uco.reactiveexample.publisher.event;

import co.edu.uco.reactiveexample.entity.CountryEntity;

public class CountryEvent {
    private CountryEntity countryEntity;
    private EventType event;
    public enum EventType{
        CREATED, UPDATED, DELETED
    }

    public CountryEvent(final CountryEntity countryEntity, final EventType event){
        super();
        setCountryEntity(countryEntity);
        setEvent(event);
    }

    public EventType getEvent() { return event; }
    public void setEvent(final EventType event) { this.event = event; }
    public CountryEntity getCountryEntity() { return countryEntity; }
    public void setCountryEntity(final CountryEntity countryEntity) { this.countryEntity = countryEntity; }
}
