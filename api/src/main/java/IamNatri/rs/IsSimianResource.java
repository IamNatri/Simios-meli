package IamNatri.rs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import IamNatri.rs.dto.ValidateSimianSignature;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;



@Consumes(MediaType.APPLICATION_JSON)
@Path("/simian")
public class IsSimianResource {

    private final Logger logger = LoggerFactory.getLogger(IsSimianResource.class);

    @POST
    @Transactional
    public Response checkIfSimian(ValidateSimianSignature validateSimianSignature) {
        logger.info("Validating if DNA is simian");
        if (validateSimianSignature.isSimian()){

            logger.info("DNA is simian");
            
            return Response.status(Response.Status.OK.getStatusCode()).build();
        }
        

        // Add your logic to check if it's a simian or not
        // and return an appropriate response
        logger.info("DNA is not simian");
        return Response.status(Response.Status.FORBIDDEN.getStatusCode()).build();

    }
}
