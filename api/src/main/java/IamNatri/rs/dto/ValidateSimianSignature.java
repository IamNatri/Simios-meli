package IamNatri.rs.dto;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateSimianSignature {
    // só podem ser: (A, T, C, G),
    // todo validar matriz only square
    // match para baixo direita e diagonal 
    // early-stop
    // 
    private String[] dna;

    private final Logger logger = LoggerFactory.getLogger(ValidateSimianSignature.class);

    public boolean isValid() {
        //cheking if the dna matriz is square
        if (dna == null || dna.length == 0) {
            logger.error("DNA é nulo ou vazio");
            return false;
        }
        for (String s: dna){
            if (s.length() != dna.length){
                logger.error("DNA matriz is not square");
                return false;
            }
            if (!s.matches("[ATCG]+")) {
                logger.error("DNA contém caracteres inválidos: " + s);
                return false;
            }
        }
      
        return true;
    }

    public boolean isSimian() {
        int v = 0;
        int h = 0;

        for (int col = 0; col < dna[0].length(); col++) {
            for(int row = 0; row<  dna.length; row++){
                logger.info("pointer h = {} v = {}", h, v);
                if (v + 3 < dna.length && h + 3 < dna[v].length()){
                    logger.info("Checking vertical");
                    logger.info("dna[{}] = `{}`", v, dna[v]);
                    logger.info("dna {} {} {} {}", dna[h].charAt(v), dna[h+1].charAt(v), dna[h+2].charAt(v), dna[h+3].charAt(v));
                        if (dna[h].charAt(v) == dna[h+1].charAt(v)
                            && dna[h].charAt(v) == dna[h+2].charAt(v)
                            && dna[h].charAt(v) == dna[h+3].charAt(v)){
                                logger.info("dna[{}].charAt({}) = `{}`", h, v, dna[h].charAt(v));
                                logger.info("dna[{}].charAt({}) = `{}`", h+1, v, dna[h+1].charAt(v+1));
                                logger.info("dna[{}].charAt({}) = `{}`", h+2, v, dna[h+2].charAt(v+2));
                                logger.info("dna[{}].charAt({}) = `{}`", h+3, v, dna[h+3].charAt(v+3));
                                logger.info("Vertical found");
                                return true;
                        }
                    
                }
                    //if the matrix is a minumum square valid 4x4 it can be checked in the entire loop just in the firts interaction
                if (h + 3 < dna[v].length() && dna.length - v >= 4){
                    logger.info("Cheking horizontal");
                    logger.info("{} , {}, {}, {}",dna[v].charAt(h), dna[v].charAt(h+1),dna[v].charAt(h+2),dna[v].charAt(h));
                    if (dna[v].charAt(h) == dna[v].charAt(h+1)
                        && dna[v].charAt(h) == dna[v].charAt(h+2)
                        && dna[v].charAt(h) == dna[v].charAt(h+3)){
                            logger.info("dna[{}].charAt({}) = `{}`", v, h, dna[v].charAt(h));
                            logger.info( "dna[{}].charAt({}) = `{}`", v, h+1, dna[v].charAt(h+1));
                            logger.info( "dna[{}].charAt({}) = `{}`", v, h+2, dna[v].charAt(h+2));
                            logger.info( "dna[{}].charAt({}) = `{}`", v, h+3, dna[v].charAt(h+3));
                            logger.info("Horizontal found");
                            return true;
                        }
                }

                        // same if the matrix is a minumum square valid 4x4 it can be checked in the entire loop just in the firts interaction
                if (dna[v].length() - h >= 4 && dna.length - v >= 4){
                    logger.info("Cheking diagonal");
                    logger.info("{} , {}, {}, {}",dna[v].charAt(h), dna[v+1].charAt(h+1),dna[v+2].charAt(h+2),dna[v+3].charAt(h+3));
                        if (dna[v].charAt(h) == dna[v+1].charAt(h+1)
                            && dna[v].charAt(h) == dna[v+2].charAt(h+2)
                            && dna[v].charAt(h) == dna[v+3].charAt(h+3)){
                                logger.info("dna[{}].charAt({}) = `{}`", v, h, dna[v].charAt(h));
                                logger.info( "dna[{}].charAt({}) = `{}`", v+1, h+1, dna[v+1].charAt(h+1));
                                logger.info( "dna[{}].charAt({}) = `{}`", v+2, h+2, dna[v+2].charAt(h+2));
                                logger.info( "dna[{}].charAt({}) = `{}`", v+3, h+3, dna[v+3].charAt(h+3));
                                logger.info("Diagonal found");
                                return true;
                            }
                }

                h++;
            }
            h = 0;
            v++;
        }
        logger.info("No vertical found");
        return false;   
    }

   // Getter
    public String[] getDna() {
        return this.dna;
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
