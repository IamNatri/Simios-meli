package IamNatri.domain.model;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "DNA.getAllSimians", query = "SELECT d FROM DNA d WHERE d.dnaType = IamNatri.domain.model.DNAType.SIMIAN")
@NamedQuery(name = "DNA.getAllHumans", query = "SELECT d FROM DNA d WHERE d.dnaType = IamNatri.domain.model.DNAType.HUMAN")
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
        return this.dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
     


}
