package ahuglajbclajep.payara.micro.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("ajax")
public class Ajax {

    @GET
    public String HelloWorld() {
        return "Hello World";
    }
}
