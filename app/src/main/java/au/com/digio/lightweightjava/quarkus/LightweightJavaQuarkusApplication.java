package au.com.digio.lightweightjava.quarkus;

import au.com.digio.lightweightjava.quarkus.model.Airport;
import au.com.digio.lightweightjava.quarkus.service.AirportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/airports")
public class LightweightJavaQuarkusApplication {

    @Inject
    private AirportService airportService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAirports() {
        List<Airport> airports = null;
        try {
            airports =  this.airportService.getAirports();
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString;
            try {
                jsonInString = mapper.writeValueAsString(airports);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return Response.status(Response.Status.OK).entity(jsonInString).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}