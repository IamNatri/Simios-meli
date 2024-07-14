package IamNatri.rs.validation;

import java.util.Arrays;

public class validateSimianSignatureII {
    String[] dna;


    boolean matchParam(int i, int j){

    }

    public boolean isSimian(){
        if (dna == null) return false;
        for (int i = 0; i < dna.length; i++){
            var line = dna[i];
            if (line != null){
                for(int j = 0; j <line.length(); j++){
                    if(matchParam(i, j)){}
                }
            }



        }
        return false;
    }


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
