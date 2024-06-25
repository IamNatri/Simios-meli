package IamNatri.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "DNA.allSimians", query = "SELECT d FROM DNA d WHERE d.dnaType = IamNatri.domain.model.DNAType.SIMIAN")
public class DNA {
    private String[] dna;
    private DNAType dnaType;


    public DNA (String[] dna, DNAType dnaType){
        this.dna = dna;
        this.dnaType = dnaType;
    }

    public DNAType getDnaType() {
        return dnaType;
    }

    public void setDnaType(DNAType dnaType) {
        this.dnaType = dnaType;
    }
    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
     


}
