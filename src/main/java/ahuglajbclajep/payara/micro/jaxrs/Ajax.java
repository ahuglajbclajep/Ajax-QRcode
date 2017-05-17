package ahuglajbclajep.payara.micro.jaxrs;

import ahuglajbclajep.payara.micro.model.QRCode;
import com.google.zxing.WriterException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("ajax")
public class Ajax {

    @POST
    @Produces("image/jpeg")
    public Response HelloWorld(String body) {
        try {
            return Response.ok(QRCode.create(body)).build();
        } catch (WriterException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
