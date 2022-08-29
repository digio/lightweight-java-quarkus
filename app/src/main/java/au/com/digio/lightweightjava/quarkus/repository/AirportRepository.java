package au.com.digio.lightweightjava.quarkus.repository;

import au.com.digio.lightweightjava.quarkus.model.Airport;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AirportRepository {

    public List<Airport> findAll() {
        Airport sydneyAirport = Airport.builder()
                .code("SYD")
                .name("Sydney Kingsford Smith International Airport")
                .country("AU")
                .gpsCode("YSSY")
                .build();

        Airport melbourneAirport = Airport.builder()
                .code("MEL")
                .name("Melbourne International Airport")
                .country("AU")
                .gpsCode("YMML")
                .build();

        return List.of(sydneyAirport, melbourneAirport);
    }
}
