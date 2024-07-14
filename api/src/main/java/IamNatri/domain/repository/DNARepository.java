package IamNatri.domain.repository;

import IamNatri.domain.model.DNA;
import IamNatri.domain.model.DNAType;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class DNARepository implements PanacheRepository<DNA> {
    //search for hashcode
    public boolean exists(int d){
        long counter = count("hashCode", d);
        return counter == 0 ? false: true;
        // (long) (count_mutant_dna != 0 ?  count_mutant_dna / count_human_dna: 0.0);

    }

    public Long countSimians() {
        PanacheQuery<DNA> simians = find("dnaType", DNAType.SIMIAN);
        return simians.count();
    }
    public Long countHumans() {
        PanacheQuery<DNA> humans = find("dnaType", DNAType.HUMAN);
        return humans.count();
        }
}
