package de.dsg.foglight.rest.api;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created with IntelliJ IDEA.
 * User: stefan
 * Date: 12.06.13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
@Path("ping")
public class PingAPI {
    @GET
    public String getMessage() {
        return "PONG" ;
    }
}
