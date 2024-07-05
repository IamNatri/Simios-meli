package IamNatri.rs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import IamNatri.domain.repository.DNARepository;
import IamNatri.domain.model.DNA;
import IamNatri.domain.model.DNAType;
import IamNatri.rs.dto.ValidateSimianSignature;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;

import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/simian")
public class IsSimianResource {

    private final Logger logger = LoggerFactory.getLogger(IsSimianResource.class);
    
    private final DNARepository dnaRepository;

    @Inject
    public IsSimianResource(DNARepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DNA> getAllSimians() {
        return dnaRepository.listAll();
    }



    @POST
    @Transactional
    public Response checkIfSimian(ValidateSimianSignature validateSimianSignature) {

        logger.info("Validating if DNA is simian");
        if (!validateSimianSignature.isValid()) {
            logger.error("DNA is not valid");
            return Response.status(Response.Status.FORBIDDEN.getStatusCode()).build();
        }
        if (validateSimianSignature.isSimian()){
            logger.info("DNA is simian");
            var dna = new DNA(validateSimianSignature.getDna(), DNAType.SIMIAN);
            dnaRepository.persist(dna);
            return Response.status(Response.Status.OK.getStatusCode()).build();
        }else{
            logger.info("Human DNA");
            var dna = new DNA(validateSimianSignature.getDna(), DNAType.HUMAN);
            dnaRepository.persist(dna);
        }
        logger.info("DNA is not simian");
        return Response.status(Response.Status.FORBIDDEN.getStatusCode()).build();

    }
}
