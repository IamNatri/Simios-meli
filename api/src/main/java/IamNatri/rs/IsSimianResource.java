package IamNatri.rs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import IamNatri.rs.dto.ValidateSimianSignature;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;



@Consumes(MediaType.APPLICATION_JSON)
@Path("/simian")
public class IsSimianResource {

    @POST
    @Transactional
    public Response checkIfSimian(ValidateSimianSignature validateSimianSignature) {

        if (validateSimianSignature.isSimian()){
            return Response.status(Response.Status.OK.getStatusCode()).build();
        }
        

        // Add your logic to check if it's a simian or not
        // and return an appropriate response
        return Response.status(Response.Status.FORBIDDEN.getStatusCode()).build();

    }
}
