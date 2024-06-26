package IamNatri.rs.dto;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateSimianSignature {

    private String[] dna;

    private final Logger logger = LoggerFactory.getLogger(ValidateSimianSignature.class);


    public boolean isSimian() {

        logger.info("dna recived `{}`", Arrays.toString(dna));

        for (int i = 0; i < dna.length; i++) {
            if (dna[i].contains("AAAA")) {
                return true;
            }
            if (dna[i].contains("TTTT")) {
                return true;
            }
            if (dna[i].contains("CCCC")) {
                return true;
            }
            if (dna[i].contains("GGGG")) {
                return true;
            }
        }

        return false;
    }

   // Getter
    public String[] getDna() {
        return dna;
    }

    // Setter
    public void setDna(String[] dna) {
        this.dna = dna;
    }

    // Método toString
    @Override
    public String toString() {
        return "ValidateSimianSignature{" +
                "dna=" + Arrays.toString(dna) +
                '}';
    }

    // Métodos equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidateSimianSignature that = (ValidateSimianSignature) o;
        return Arrays.equals(dna, that.dna);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(dna);
    }


}
