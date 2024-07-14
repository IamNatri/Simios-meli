package IamNatri.domain.model;

import jakarta.persistence.*;

@Entity
public class DNA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DNAType dnaType;
    // TODO use char256
    private int hashCode;

    DNA() {
    }

    public DNA(int hashCode, DNAType dnaType) {
        this.hashCode = hashCode;
        this.dnaType = dnaType;
    }

    public DNAType getDnaType() {
        return dnaType;
    }

    public void setDnaType(DNAType dnaType) {
        this.dnaType = dnaType;
    }

    

}
