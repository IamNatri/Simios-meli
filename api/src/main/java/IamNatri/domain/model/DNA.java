package IamNatri.domain.model;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "DNA.allSimians", query = "SELECT d FROM DNA d WHERE d.dnaType = IamNatri.domain.model.DNAType.SIMIAN")
public class DNA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String[] dna;
    private DNAType dnaType;

    DNA() {}


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
