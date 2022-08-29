package au.com.digio.lightweightjava.quarkus.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "name", "code", "gpsCode", "country" })
@Builder
public class Airport {

    private String code;

    private String name;

    private String country;

    private String gpsCode;
}

