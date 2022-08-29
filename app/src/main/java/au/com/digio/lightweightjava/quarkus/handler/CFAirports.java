package au.com.digio.lightweightjava.quarkus.handler;

import au.com.digio.lightweightjava.quarkus.model.Airport;
import au.com.digio.lightweightjava.quarkus.service.AirportService;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("airports")
public class CFAirports implements RequestHandler<Object, List<Airport>> {

    private static Logger logger = LoggerFactory.getLogger(CFAirports.class);

    @Inject
    AirportService airportService;

    @Override
    public List<Airport> handleRequest(Object input, Context context) {
        logger.info("Getting airports");
        try {
            return airportService.getAirports();
        } catch (Exception e) {
            logger.error("Error while getting airports", e);
            throw new RuntimeException(e);
        }
    }
}
