package IamNatri.rs;


import IamNatri.domain.repository.DNARepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("/stats")
public class statsResource {

    public final DNARepository dnaRepository;

    @Inject
    public statsResource(DNARepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }
    
    @GET
    public String getStats() {
        Long count_mutant_dna = dnaRepository.countSimians();
        Long count_human_dna = dnaRepository.countHumans();
        Long ratio = (long) (count_mutant_dna != 0 ?  count_mutant_dna / count_human_dna: 0.0); 
        //creating the json response
        

        return "{\"count_mutant_dna\": %d, \"count_human_dna\": %d, \"ratio\": %d}".formatted(count_mutant_dna, count_human_dna, ratio);
        
    }
}
