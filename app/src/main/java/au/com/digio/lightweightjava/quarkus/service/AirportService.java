package au.com.digio.lightweightjava.quarkus.service;

import au.com.digio.lightweightjava.quarkus.model.Airport;
import au.com.digio.lightweightjava.quarkus.repository.AirportRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class AirportService {

    @Inject
    AirportRepository airportRepository;

    public List<Airport> getAirports(){
        return airportRepository.findAll();
    }
}
